package site.javaee.cloud_consumer_order_82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Order_82 {

    public static void main(String[] args) {
        SpringApplication.run(Order_82.class, args);
    }

}
