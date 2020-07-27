package site.javaee.cloud_provider_payment_8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment_8004 {

    public static void main(String[] args) {
        SpringApplication.run(Payment_8004.class, args);
    }

}
