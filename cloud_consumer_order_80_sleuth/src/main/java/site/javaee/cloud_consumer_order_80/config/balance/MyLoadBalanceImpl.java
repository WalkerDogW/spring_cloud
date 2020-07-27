package site.javaee.cloud_consumer_order_80.config.balance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shkstart
 * @create 2020-07-07 10:26
 */
@Component
public class MyLoadBalanceImpl implements MyLoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            if (current >= Integer.MAX_VALUE) {
                next = 0;
            } else {
                next = current + 1;
            }
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***********第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
