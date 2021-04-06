package com.example.rabbitmqdemo.boot.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.rabbitmqdemo.boot.route.RouteConsumer
 * @description
 * @date 2021/3/26 0026
 * //TODO
 */
@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct",type = "direct"),
                    key = {"info"}
            )
    })
    public void receiver1(String msg){
        System.out.println("receiver1:"+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct",type = "direct"),
                    key = {"error"}
            )
    })
    public void receiver2(String msg){
        System.out.println("receiver2:"+msg);
    }

}
