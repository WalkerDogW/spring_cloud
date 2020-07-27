package site.javaee.cloud__stream_8803_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class StreamConsumer8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8803.class, args);
    }

}
