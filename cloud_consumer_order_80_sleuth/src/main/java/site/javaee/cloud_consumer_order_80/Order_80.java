package site.javaee.cloud_consumer_order_80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import site.javaee.ribbon.MySelfRule;

@EnableEurekaClient
@SpringBootApplication
//改成自定义的负载算法
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class Order_80 {

    public static void main(String[] args) {
        SpringApplication.run(Order_80.class, args);
    }

}
