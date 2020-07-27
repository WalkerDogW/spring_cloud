package site.javaee.cloud_consumer_order_80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author shkstart
 * @create 2020-07-04 15:22
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
