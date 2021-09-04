package com.example.rabbitmqdemo.ysj.hello;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/3 0003
 * //TODO
 */
public class Consumer {
    private static final String QUEUE_NAME = "test";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接
        Connection connection = HelloRabbitMq.getConnection();
        // 2.设置通道
        Channel channel = connection.createChannel();
        // 开启确认机制
        channel.confirmSelect();

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("消费者获取消息:" + msg);
                Integer deliveryMode = properties.getDeliveryMode();
                long deliveryTag = envelope.getDeliveryTag();
                // 签收
                channel.basicAck(deliveryTag,false);
                channel.close();
                connection.close();
            }
        };
        // 3.监听队列
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);
    }
}
