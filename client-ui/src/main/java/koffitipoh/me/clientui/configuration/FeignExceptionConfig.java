package koffitipoh.me.clientui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import koffitipoh.me.clientui.exceptions.CustomerErrorDecoder;

@Configuration
public class FeignExceptionConfig {
    @Bean
    public CustomerErrorDecoder mCustomerErrorDecoder() {
        return new CustomerErrorDecoder();
    }
}
