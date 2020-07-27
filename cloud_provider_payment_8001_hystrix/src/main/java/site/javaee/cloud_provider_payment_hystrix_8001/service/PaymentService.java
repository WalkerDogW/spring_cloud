package site.javaee.cloud_provider_payment_hystrix_8001.service;


import org.springframework.web.bind.annotation.PathVariable;
import site.jaavee.cloud_api_commons.entities.Payment;

/**
 * @author shkstart
 * @create 2020-07-04 9:37
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
