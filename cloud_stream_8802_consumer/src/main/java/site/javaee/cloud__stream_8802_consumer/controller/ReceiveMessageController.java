package site.javaee.cloud__stream_8802_consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;


/**
 * @author shkstart
 * @create 2020-07-16 15:15
 */
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("$server.port")
    private String serverPort;



    @StreamListener(Sink.INPUT)
    public void input(Message<String>message){
        System.out.println("消费者1号,-->消息：" + message.getPayload()+"\t"+serverPort);
    }
}
