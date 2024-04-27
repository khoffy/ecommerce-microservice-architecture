package koffitipoh.me.clientui.beans;

import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class TokensBean {
    private String access_token;
    private String refresh_token;
    private String error_message;
}
