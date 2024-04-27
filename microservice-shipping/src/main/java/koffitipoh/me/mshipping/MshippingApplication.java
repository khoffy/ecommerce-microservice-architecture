package koffitipoh.me.mshipping;

import koffitipoh.me.mshipping.config.RsaKeysConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(RsaKeysConfig.class)
public class MshippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MshippingApplication.class, args);
	}

}
