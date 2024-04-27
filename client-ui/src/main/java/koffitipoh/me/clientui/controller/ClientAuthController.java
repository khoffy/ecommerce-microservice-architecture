package koffitipoh.me.clientui.controller;

import koffitipoh.me.clientui.beans.AuthenticationBean;
import koffitipoh.me.clientui.beans.TokensBean;
import koffitipoh.me.clientui.proxies.MicroserviceAuthProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientAuthController {

    private MicroserviceAuthProxy microserviceAuthProxy;

    @PostMapping("/token")
    public ResponseEntity<TokensBean> getToken(@RequestBody AuthenticationBean authBean) {
        return microserviceAuthProxy.getTokens(authBean);
    }

    @Autowired
    public void setMicroserviceAuthProxy(MicroserviceAuthProxy microserviceAuthProxy) {
        this.microserviceAuthProxy = microserviceAuthProxy;
    }
}
