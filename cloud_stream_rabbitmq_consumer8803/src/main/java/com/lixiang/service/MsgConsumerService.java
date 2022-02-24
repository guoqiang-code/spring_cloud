package com.lixiang.service;

import org.springframework.messaging.Message;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/17 15:08
 */
public interface MsgConsumerService {


    public void accept(Message<String> message);
}
