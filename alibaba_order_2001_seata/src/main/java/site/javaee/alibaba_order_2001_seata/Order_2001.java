package site.javaee.alibaba_order_2001_seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Order_2001 {

    public static void main(String[] args) {
        SpringApplication.run(Order_2001.class, args);
    }

}
