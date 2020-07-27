package site.javaee.cloud_gateway_9527.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shkstart
 * @create 2020-07-09 2:53
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator path_route1 =
                routes.
                route("path_route1", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
        return path_route1;
    }
}
