package com.example.rabbitmqdemo.boot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.rabbitmqdemo.boot.hello.Consumer1
 * @description
 * @date 2021/3/26 0026
 * //TODO
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class Consumer1 {

    @RabbitHandler
    public void recv1(String msg){
        System.out.println(msg);
    }

}
