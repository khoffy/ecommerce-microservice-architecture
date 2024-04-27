package koffitipoh.me.msecurity.beans;

import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class AuthenticationBean {
    private String username;
    private String password;
    private Boolean withRefreshToken;
    private String grantType;
    private String refreshToken;
}
