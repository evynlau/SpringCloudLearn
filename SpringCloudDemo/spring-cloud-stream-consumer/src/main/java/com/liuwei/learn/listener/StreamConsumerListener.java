package com.liuwei.learn.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuWei
 * @Date: Created in 2021/9/14 16:55
 * @Package: com.liuwei.learn.listener
 * @Modified By:
 * @Description:
 */
@Component
@EnableBinding(Sink.class)
public class StreamConsumerListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println("消费者 port "+serverPort+" receive message: "+ message.getPayload());
    }
}
