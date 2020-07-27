package site.javaee.cloud_provider_payment_8004.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.jaavee.cloud_api_commons.entities.Payment;


/**
 * @author shkstart
 * @create 2020-07-04 9:16
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
