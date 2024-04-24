package koffitipoh.me.clientui.configuration;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.netflix.eureka.reactive.EurekaReactiveDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
            ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier.builder()
                //.withBlockingDiscoveryClient()
                //.withSameInstancePreference()
                .withDiscoveryClient()
                .withHealthChecks()
                .build(context);
    }

//    @Bean
//    public ReactiveDiscoveryClient reactiveDiscoveryClient() {
//        // Return an instance of the ReactiveDiscoveryClient implementation
//        // For example, EurekaReactiveDiscoveryClient if using Eureka
//        return new EurekaReactiveDiscoveryClient();
//    }
}




