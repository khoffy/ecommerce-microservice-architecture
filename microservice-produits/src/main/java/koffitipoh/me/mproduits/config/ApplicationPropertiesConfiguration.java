package koffitipoh.me.mproduits.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("own-config")
@RefreshScope                    
public class ApplicationPropertiesConfiguration {
    private int limitOfProducts;

    public int getLimitOfProducts() {
        return limitOfProducts;
    }

    public void setLimitOfProducts(int limitOfProducts) {
        this.limitOfProducts = limitOfProducts;
    }    
}

