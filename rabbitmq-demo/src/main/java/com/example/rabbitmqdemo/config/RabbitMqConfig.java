package com.example.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/5 0005
 * //TODO
 */
@Slf4j
@Configuration
public class RabbitMqConfig {

    /**
     * 指定rabbitmq消息的序列化方式（json）
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 定制化RabbitTemplate
     */
    @PostConstruct // RabbitMqConfig实例化后执行
    public void initRabbitTemplate(){
        /**
         * 消息投递回调-迭代交换机回调(指的是投递到rabbitmq-server服务器)
         * Confirmation callback.
         * @param correlationData correlation data for the callback.
         * @param ack true for ack, false for nack
         * @param cause An optional cause, for nack, when available, otherwise null.
         */
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            log.info("correlationData-id:{},ack:{},cause:{}",correlationData.getId(),ack,cause);
        });

        /**
         * 消息投递到队列失败之后的回调
         */
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {

            /**
             * 消息参数解释：org.springframework.amqp.core.ReturnedMessage
             * ReturnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey)
             * @param returned
             */
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                returned.getMessage();
                returned.getReplyCode();
                returned.getReplyText();
                returned.getExchange();
                returned.getRoutingKey();
            }
        });
    }

    /**
     * 使用@Bean的方式注入exchange,queue,binding
     * @return
     */
    @Bean
    public Exchange orderEventExchange(){
        return new DirectExchange("order-event-exchange",true,false);
    }

}
