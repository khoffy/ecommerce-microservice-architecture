package koffitipoh.me.clientui.proxies;

import koffitipoh.me.clientui.beans.AuthenticationBean;
import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.beans.TokensBean;
import koffitipoh.me.clientui.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

// @FeignClient(name = "microservice-produits", url = "localhost:9001")
// We remove url parameter cause we're going to launch multiple instances 
// on various port for load balancing with Load Balancer
@FeignClient(name = "security-gateway", url = "localhost:9102")
@LoadBalancerClient(name = "microservice-security", configuration = LoadBalancerConfiguration.class)
public interface MicroserviceAuthProxy {
    @PostMapping(value = "/auth/token")
    ResponseEntity<TokensBean> getTokens(@RequestBody AuthenticationBean authBean);
}
