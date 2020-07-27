package site.javaee.alibaba_sentinel_8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.jaavee.cloud_api_commons.entities.CommonResult;
import site.jaavee.cloud_api_commons.entities.Payment;
import site.javaee.alibaba_sentinel_8401.config.CustomerBlockHandler;

/**
 * @author shkstart
 * @create 2020-07-25 11:21
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleByResource")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试", new Payment(2020L,"serial001"));
    }
    public CommonResult handleByResource(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName()+"\t"+"服务不可用");
    }


    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleByUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按Url限流测试", new Payment(2020L,"serial002"));
    }


    @GetMapping("/byCustomerBlockHandler")
    @SentinelResource(value = "byCustomerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult byCustomerBlockHandler(){

        return new CommonResult(200, "自定义处理", new Payment(2020L,"serial003"));
    }

}
