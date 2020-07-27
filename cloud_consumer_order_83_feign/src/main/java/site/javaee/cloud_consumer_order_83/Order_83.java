package site.javaee.cloud_consumer_order_83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Order_83 {

    public static void main(String[] args) {
        SpringApplication.run(Order_83.class, args);
    }

}
