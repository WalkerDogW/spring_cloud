package site.javaee.cloud_provider_payment_8005.service;


import site.jaavee.cloud_api_commons.entities.Payment;

/**
 * @author shkstart
 * @create 2020-07-04 9:37
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
