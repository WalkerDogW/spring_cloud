package site.javaee.cloud_consumer_order_80.config.balance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写一个负载的算法
 *
 * @author shkstart
 * @create 2020-07-07 10:12
 */
public interface MyLoadBalance {
    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
