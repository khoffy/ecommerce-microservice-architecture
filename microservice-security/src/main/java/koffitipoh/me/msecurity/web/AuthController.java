package koffitipoh.me.msecurity.web;

import koffitipoh.me.msecurity.beans.AuthenticationBean;
import koffitipoh.me.msecurity.beans.TokensBean;
import koffitipoh.me.msecurity.service.AuthService;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<TokensBean> jwtToken(@RequestBody AuthenticationBean authBean) {
        ResponseEntity<TokensBean> responseEntity;

        TokensBean tokensBean = authService.jwtToken(authBean.getGrantType(), authBean.getUsername(),
                authBean.getPassword(), authBean.getWithRefreshToken(), authBean.getRefreshToken());

        if(Objects.nonNull(tokensBean.getError_message())) {
            responseEntity = new ResponseEntity<>(tokensBean, HttpStatus.UNAUTHORIZED);
        } else {
            responseEntity = new ResponseEntity<>(tokensBean, HttpStatus.OK);
        }
        return responseEntity;
    }
}
