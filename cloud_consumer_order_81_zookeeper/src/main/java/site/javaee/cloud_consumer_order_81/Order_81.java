package site.javaee.cloud_consumer_order_81;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Order_81 {

    public static void main(String[] args) {
        SpringApplication.run(Order_81.class, args);
    }

}
