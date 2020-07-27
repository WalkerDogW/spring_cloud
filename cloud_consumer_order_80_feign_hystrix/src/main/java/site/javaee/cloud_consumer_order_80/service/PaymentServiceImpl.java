package site.javaee.cloud_consumer_order_80.service;

import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2020-07-08 11:20
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "payment_Global_Fallback";
    }
}
