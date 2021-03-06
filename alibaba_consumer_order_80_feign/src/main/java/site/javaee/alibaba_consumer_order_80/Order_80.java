package site.javaee.alibaba_consumer_order_80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Order_80 {

    public static void main(String[] args) {
        SpringApplication.run(Order_80.class, args);
    }

}
