package koffitipoh.me.msecurity.service;

import koffitipoh.me.msecurity.beans.TokensBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    public TokensBean jwtToken(String grantType, String username, String password,
                               boolean withRefreshToken, String refreshToken) {
        TokensBean tokensBean = new TokensBean();
        String subject = null;
        String scope = null;
        if(grantType.equals("password")) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            subject = authentication.getName();
            scope = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
        } else if (grantType.equals("refreshToken")) {
            if(Objects.isNull(refreshToken)) {
                tokensBean.setError_message("Refresh token is required");
                //return new ResponseEntity<>(tokensBean, HttpStatus.UNAUTHORIZED);
                return tokensBean;
            }
            Jwt decodeJwt = null;
            try {
                decodeJwt = jwtDecoder.decode(refreshToken);
            } catch (JwtException e) {
                tokensBean.setError_message(e.getMessage());
                return tokensBean;
            }

            subject = decodeJwt.getSubject(); // Get the username
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
            //Get user's roles
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // Get user's scope
            scope = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        }

        //Map<String, String> idToken = new HashMap<>();
        Instant instant = Instant.now();

        assert subject != null;
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(15, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope", scope)
                .build();

        String jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        tokensBean.setAccess_token(jwtAccessToken);

        if(withRefreshToken) {
            JwtClaimsSet jwtClaimsSetRefresh = JwtClaimsSet.builder()
                    .subject(subject)
                    .issuedAt(instant)
                    .expiresAt(instant.plus(15, ChronoUnit.MINUTES))
                    //.claim("scope", scope)  # no need to send user's roles for refresh token
                    .build();

            String jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            tokensBean.setRefresh_token(jwtRefreshToken);
        }
        return tokensBean;
    }
}

