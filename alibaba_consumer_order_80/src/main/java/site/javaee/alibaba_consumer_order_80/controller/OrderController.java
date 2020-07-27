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
    private RestTemplate restTemplate;


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



    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "fallbackHandle",exceptionsToIgnore = {NullPointerException.class})
    public CommonResult fallback(@PathVariable("id") Long id) {
        if(id==4){
            throw new IllegalArgumentException("参数异常");
        }else if(id==5){
            throw new NullPointerException("空指针异常");
        }
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    public CommonResult fallbackHandle(@PathVariable("id") Long id,Throwable e) {
        return new CommonResult(444, "兜底异常："+e.getMessage(),new Payment());
    }


}
