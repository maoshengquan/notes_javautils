package com.example.rabbitmqdemo.ysj.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/3 0003
 * //TODO
 */
@Slf4j
@Component
@RabbitListener(queues = "fanout_sms_queue")
public class FanoutSmsConsumer {

    @RabbitHandler
    public void process(String msg) {
        log.info(">>短信消费者消息msg:{}<<", msg);
    }
}