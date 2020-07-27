package site.javaee.cloud_provider_payment_hystrix_8001.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.cloud_provider_payment_hystrix_8001.dao.PaymentDao;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shkstart
 * @create 2020-07-04 9:16
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " OK, id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5000;
        //int error = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " TimeOut, id: " + id + "\t" + "O(∩_∩)O哈哈~" + "\t耗时：" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "8001线程池：" + Thread.currentThread().getName() + " TimeOut, id: " + id + "\t" + "o(╥﹏╥)o" + "\t：" + "调用支付接口超时或异常";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期，即时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*** id不能为负");
        }
        String serialNumber = UUID.randomUUID().toString();
        return "8001线程池：" + Thread.currentThread().getName() + " 调用成功，流水号：" + serialNumber;
    }


    public String paymentCircuitBreaker_fallback(Integer id) {
        return "8001线程池：" + Thread.currentThread().getName() + " 调用失败，id不能为负数";
    }


}
