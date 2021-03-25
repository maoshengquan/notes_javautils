package com.example.rabbitmqdemo.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.rabbitmqdemo.simple.FairNewTask
 * @description
 * @date 2021/3/24 0024
 * //TODO
 */
public class FairNewTask {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();
        // 指定一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 公平转发
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);

        // 指定exchanger - fanout
        channel.exchangeDeclare("logs", "fanout");

        // 发送消息
        for (int i = 10; i >0; i--) {
            String message = "Liang:" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        // 关闭频道和连接
        channel.close();
        connection.close();
    }

}
