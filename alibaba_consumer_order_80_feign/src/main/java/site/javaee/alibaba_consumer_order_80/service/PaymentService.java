package site.javaee.alibaba_consumer_order_80.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;

/**
 * @author shkstart
 * @create 2020-07-25 23:01
 */
@FeignClient(value = "nacos-payment-service",fallback = PaymentFallbackServivce.class)
public interface PaymentService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
