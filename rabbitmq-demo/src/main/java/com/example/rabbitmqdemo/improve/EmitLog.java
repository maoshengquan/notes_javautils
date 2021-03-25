package com.example.rabbitmqdemo.improve;

import com.rabbitmq.client.*;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.example.rabbitmqdemo.improve.EmitLog
 * @description
 * @date 2021/3/24 0024
 * //TODO
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置 RabbitMQ 的主机名
        factory.setHost("localhost");
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();
        // 指定一个交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 发送消息
        String message = "Liang-MSG log.";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        // 关闭频道和连接
        channel.close();
        connection.close();
    }

}
