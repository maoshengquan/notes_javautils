package com.example.bootrocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.bootrocketmq.consumer.Consumer
 * @description
 * @date 2021/3/15 0015
 * //TODO
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "springboot-mq",consumerGroup = "${rocketmq.consumer.group}")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Receive message："+message);
    }
}
