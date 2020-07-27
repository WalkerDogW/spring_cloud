package site.javaee.alibaba_provider_payment_9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment_9002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment_9002.class, args);
    }

}
