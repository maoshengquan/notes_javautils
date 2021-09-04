package com.example.rabbitmqdemo.lisener;

import com.example.rabbitmqdemo.entity.OrderEntity;
import com.example.rabbitmqdemo.entity.UserEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/5 0005
 * //TODO
 */
@Component
@RabbitListener(queues={"rabbitmq-java-queue"}) // 订阅rabbitmq-java-queue主题
public class RabbitmqDemoLisener {

    /**
     * 接收消息类型是UserEntity消息
     * @param message
     */
    @RabbitHandler
    public void listener(UserEntity entity){
        System.out.println("收到消息UserEntity:"+entity.toString());
    }

    /**
     * 接收消息类型是OrderEntity消息
     * @param entity
     */
    @RabbitHandler
    public void listener(OrderEntity entity, Message message,Channel channel){
        System.out.println("收到消息OrderEntity:"+entity.toString());

        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 签收
            channel.basicAck(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
            // 拒绝签收
            try {
                // requeue: true-重新入队列，false-丢弃
                // multiple 是否批量拒收
                channel.basicNack(deliveryTag,false,false);

                // channel.basicReject(deliveryTag,true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
