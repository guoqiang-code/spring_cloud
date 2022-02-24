package com.lixiang.service.impl;

import com.lixiang.service.MsgConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/17 15:09
 */
@Slf4j
@Component
@EnableBinding(Sink.class)
public class MsgConsumerServiceImpl implements MsgConsumerService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    @StreamListener(Sink.INPUT)
    public void accept(Message<String> message) {
        log.error("消费者端口号："+serverPort+"\t消费的信息:"+message.getPayload());
        System.out.println("消费者端口号："+serverPort+"\t消费的信息:"+message.getPayload());
    }
}
