package com.example.rabbitmqdemo.ysj.hello.fanout;

import com.example.rabbitmqdemo.ysj.hello.HelloRabbitMq;
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
public class ProducerFanout {
    /**
     * 定义交换机的名称
     */
    private static final String EXCHANGE_NAME = "fanout_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = HelloRabbitMq.getConnection();
        // 创建Channel
        Channel channel = connection.createChannel();
        // 通道关联交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true);
        String msg = "6666666";
        channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
        channel.close();
        connection.close();
    }

}
