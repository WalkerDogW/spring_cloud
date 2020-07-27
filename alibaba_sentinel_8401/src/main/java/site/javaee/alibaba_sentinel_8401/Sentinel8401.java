package site.javaee.alibaba_sentinel_8401;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class, args);
    }

}
