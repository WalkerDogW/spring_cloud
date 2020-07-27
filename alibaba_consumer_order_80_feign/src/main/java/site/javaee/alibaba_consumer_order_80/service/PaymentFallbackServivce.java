package site.javaee.alibaba_consumer_order_80.service;

import org.springframework.stereotype.Component;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;

/**
 * @author shkstart
 * @create 2020-07-25 23:06
 */
@Component
public class PaymentFallbackServivce  implements  PaymentService{
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(444, "服务降级返回-----paymentFallbackService",new Payment(id, "errorSerial"));
    }
}
