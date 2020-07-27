package site.javaee.alibaba_provider_payment_9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment_9001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment_9001.class, args);
    }

}
