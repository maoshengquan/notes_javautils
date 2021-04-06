package com.example.rabbitmqdemo.boot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.rabbitmqdemo.boot.work.Work
 * @description
 * @date 2021/3/26 0026
 * //TODO
 */
@Component
public class Work {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver1(String msg){
        System.out.println("receiver1:"+msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver2(String msg){
        System.out.println("receiver2:"+msg);
    }

}
