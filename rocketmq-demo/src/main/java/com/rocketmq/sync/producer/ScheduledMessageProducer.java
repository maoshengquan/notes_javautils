package com.rocketmq.sync.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.rocketmq.sync.producer.ScheduledMessageProducer
 * @description  发送延时消息
 * @date 2021/3/13 0013
 * //TODO
 */
public class ScheduledMessageProducer {

    public static void main(String[] args) throws Exception {
        // 实例化一个生产者来产生延时消息
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.139.128:9876;192.168.139.129:9876");
        // 启动生产者
        producer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("testtopic-test2", "TAGA",("Hello scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            message.setDelayTimeLevel(3);
            // 消息属性
            message.putUserProperty("number","5");
            // 发送消息
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);

        }
        // 关闭生产者
        System.in.read();
        producer.shutdown();

    }
}
