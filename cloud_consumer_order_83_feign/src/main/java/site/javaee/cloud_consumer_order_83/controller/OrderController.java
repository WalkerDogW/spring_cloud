package site.javaee.cloud_consumer_order_83.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.cloud_consumer_order_83.service.PaymentService;


import javax.annotation.Resource;


/**
 * @author shkstart
 * @create 2020-07-04 15:16
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private PaymentService paymentService;


    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }


}
