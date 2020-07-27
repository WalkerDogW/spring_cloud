package site.javaee.cloud_consumer_order_80.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.javaee.cloud_consumer_order_80.service.PaymentService;


import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-07-04 15:16
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_Fallback")
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2500")
    })*/
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "消费者80：线程池：" + Thread.currentThread().getName() + " TimeOut, id: " + id + "\t" + "o(╥﹏╥)o" + "\t：" + "调用支付接口超时或异常";
    }

    /*
    @GetMapping("/consumer/payment/hystrix/timeout2/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut2(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_TimeOut(id);
    }
    //全局fallback
    public String payment_Global_Fallback(){
        return "payment_Global_Fallback";
    }

     */
}
