package koffitipoh.me.clientui.proxies;

import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.beans.ShippingBean;
import koffitipoh.me.clientui.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// @FeignClient(name = "microservice-produits", url = "localhost:9001")
// We remove url parameter cause we're going to launch multiple instances 
// on various port for load balancing with Load Balancer
@FeignClient(name = "shipping-gateway", url = "localhost:9103")
@LoadBalancerClient(name = "microservice-shippings", configuration = LoadBalancerConfiguration.class)
public interface MicroserviceShippingsProxy {

    @PostMapping("/shippings")
    ShippingBean create(@RequestBody ShippingBean shippingBean);

    @GetMapping(value = "/shippings")
    List<ShippingBean> shippingsList();

   @GetMapping( value = "/shippings/{id}")
   ShippingBean getShippingById(@PathVariable("id") int id);
}
