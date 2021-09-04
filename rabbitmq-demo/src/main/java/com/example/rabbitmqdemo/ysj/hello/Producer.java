package com.example.rabbitmqdemo.ysj.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/3 0003
 * //TODO
 */
public class Producer {
    private static final String QUEUE_NAME = "test";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接
        Connection connection = HelloRabbitMq.getConnection();
        // 2.设置通道
        Channel channel = connection.createChannel();
        // 开启确认机制
        channel.confirmSelect();
        // 3.设置消息
        String msg = "我是消息";
        System.out.println("msg:" + msg);
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        channel.close();
        connection.close();
    }
}
