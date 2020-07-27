package site.javaee.cloud__stream_8801_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.javaee.cloud__stream_8801_provider.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-07-16 15:15
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        String message = messageProvider.send();
        return message;
    }
}
