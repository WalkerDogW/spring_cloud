package site.javaee.alibaba_provider_payment_9002.service;


import org.springframework.stereotype.Service;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.alibaba_provider_payment_9002.dao.PaymentDao;


import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-07-04 9:16
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
