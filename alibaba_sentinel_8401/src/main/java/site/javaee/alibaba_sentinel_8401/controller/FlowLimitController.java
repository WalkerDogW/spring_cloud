package site.javaee.alibaba_sentinel_8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2020-07-23 20:30
 */
@Slf4j
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        log.info("testD 异常比例");
        int age=10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试异常数量");
        int age=10/0;
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey, o(╥﹏╥)o";
    }



}
