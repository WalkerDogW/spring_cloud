package site.javaee.cloud__stream_8801_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class StreamProvider8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamProvider8801.class, args);
    }

}
