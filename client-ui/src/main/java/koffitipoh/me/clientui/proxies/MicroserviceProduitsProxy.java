package koffitipoh.me.clientui.proxies;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.configuration.LoadBalancerConfiguration;

// @FeignClient(name = "microservice-produits", url = "localhost:9001")
// We remove url parameter cause we're going to launch multiple instances 
// on various port for load balancing with Load Balancer
@FeignClient(name = "gateway-server", url = "localhost:9103")
@LoadBalancerClient(name = "microservice-produits", configuration = LoadBalancerConfiguration.class)
public interface MicroserviceProduitsProxy {
    @GetMapping(value = "/produits")
    List<ProductBean> listeDesProduits();

   @GetMapping( value = "/produits/{id}")
   ProductBean recupererUnProduit(@PathVariable("id") int id);    
}


