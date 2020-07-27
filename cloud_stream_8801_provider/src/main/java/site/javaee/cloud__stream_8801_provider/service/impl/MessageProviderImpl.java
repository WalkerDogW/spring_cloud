package site.javaee.cloud__stream_8801_provider.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import site.javaee.cloud__stream_8801_provider.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2020-07-16 14:59
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl  implements IMessageProvider {
    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial: "+serial);
        return serial;
    }
}
