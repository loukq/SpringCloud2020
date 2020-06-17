package com.lou.springcloud.service.impl;

import com.lou.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送的管道
public class MessageProviderImpl implements MessageService {

    @Autowired
    private MessageChannel output;//消息的发送的管道

    @Override
    public String send() {
        String message= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("------message:"+message);
        return null;
    }
}
