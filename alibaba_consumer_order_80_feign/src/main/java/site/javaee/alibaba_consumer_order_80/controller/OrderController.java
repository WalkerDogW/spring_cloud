package site.javaee.alibaba_consumer_order_80.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.alibaba_consumer_order_80.service.PaymentService;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-04 15:16
 */
@RestController
@Slf4j
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    public String PAYMENT_URL;

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }



}
