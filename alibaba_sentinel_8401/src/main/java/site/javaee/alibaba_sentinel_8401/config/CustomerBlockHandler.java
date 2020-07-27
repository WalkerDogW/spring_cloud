package site.javaee.alibaba_sentinel_8401.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;

/**
 * @author shkstart
 * @create 2020-07-25 11:51
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "自定义统一处理测试", new Payment(2020L,"serial003------1"));
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "自定义统一处理测试", new Payment(2020L,"serial003------2"));
    }
}
