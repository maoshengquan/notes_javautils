package com.example.rabbitmqdemo.ysj.hello;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/3 0003
 * //TODO
 */
public class HelloRabbitMq {
    /**
     * 获取连接
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        // 1.创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2.设置连接地址
        connectionFactory.setHost("1.117.161.22");
        // 3.设置端口号:
        connectionFactory.setPort(5672);
        // 4.设置账号和密码
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 5.设置VirtualHost
        connectionFactory.setVirtualHost("/study");
        return connectionFactory.newConnection();
    }
}

