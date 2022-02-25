package com.lixiang.service.impl;

import com.lixiang.service.MsgProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/16 18:19
 */
//定义消息的推送管道
@EnableBinding(Source.class)
public class MsgProviderImpl implements MsgProvider {

    @Resource
    private MessageChannel output;//消息发送管道

    //默认是不同的组，会出现重复消费
    //更改成同一个组下消费可以避免重复消费
    @Override
    public String send() {
        String msg = "rabbitMQ消息发送，ID:" + UUID.randomUUID();
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("发送成功~~~~~~~~~~~~~~~~~~~~~");
        return "欢迎光临";
    }
}
