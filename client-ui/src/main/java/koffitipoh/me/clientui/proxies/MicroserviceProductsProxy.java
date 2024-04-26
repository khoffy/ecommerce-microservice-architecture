package koffitipoh.me.clientui.proxies;

import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient(name = "microservice-produits", url = "localhost:9001")
// We remove url parameter cause we're going to launch multiple instances 
// on various port for load balancing with Load Balancer
@FeignClient(name = "products-gateway", url = "localhost:9102")
@LoadBalancerClient(name = "microservice-products", configuration = LoadBalancerConfiguration.class)
public interface MicroserviceProductsProxy {
    @GetMapping(value = "/products")
    List<ProductBean> productsList();

   @GetMapping( value = "/products/{id}")
   ProductBean getProductById(@PathVariable("id") int id);
}
