package site.javaee.cloud_consumer_order_80.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.cloud_consumer_order_80.config.balance.MyLoadBalance;

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
    public static final String PAYMENT_NAME = "CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL = "http://"+PAYMENT_NAME;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_NAME);
        if (instances == null || instances.size() <= 0) {
            System.out.println("instances null");
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping(value = "/consumer/payment/get")
    public CommonResult getPaymentLB2() {
        System.out.println("****************");
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_NAME);
        if (instances == null || instances.size() <= 0) {
            System.out.println("instances null");
            return null;

        }
        ServiceInstance serviceInstance = myLoadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/1", CommonResult.class);
    }



}
