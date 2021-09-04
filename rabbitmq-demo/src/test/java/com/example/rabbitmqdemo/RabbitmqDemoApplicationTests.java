package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.entity.OrderEntity;
import com.example.rabbitmqdemo.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Slf4j
@SpringBootTest(classes = RabbitmqDemoApplication.class )
class RabbitmqDemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void createExchange(){
        // public DirectExchange(String name, boolean durable, boolean autoDelete)
        Exchange exchange = new DirectExchange("rabbitmq-java-exchange",true,false);
        amqpAdmin.declareExchange(exchange);
        log.info("交换机创建成功:{}","rabbitmq-java-exchange");
    }

    @Test
    void createQueue(){
        // public Queue(String name, boolean durable, boolean exclusive, boolean autoDelete, @Nullable Map<String, Object> arguments)
        Queue queue = new Queue("rabbitmq-java-queue",true,false,false,null);
        amqpAdmin.declareQueue(queue);
        log.info("队列创建成功:{}","rabbitmq-java-queue");
    }

    @Test
    void binding(){
        // public Binding(String destination, DestinationType destinationType, String exchange, String routingKey,
        //			@Nullable Map<String, Object> arguments)
        Binding binding = new Binding("rabbitmq-java-queue",Binding.DestinationType.QUEUE,"rabbitmq-java-exchange","hello.rabbitmq",null);
        amqpAdmin.declareBinding(binding);
        log.info("交换机rabbitmq-java-exchange和队列rabbitmq-java-queue绑定成功");
    }

    @Test
    void sendMsgUserEntity(){
        UserEntity userEntity = new UserEntity(10001,"我是user消息");
        // new CorrelationData(UUID.randomUUID().toString()消息的标识
        rabbitTemplate.convertAndSend("rabbitmq-java-exchange","hello.rabbitmq",userEntity,new CorrelationData(UUID.randomUUID().toString()));
        log.info("向交换机rabbitmq-java-exchange绑定路由键hello.rabbitmq消息");
    }

    @Test
    void sendMsgOrderEntity(){
        OrderEntity orderEntity = new OrderEntity(10001,"我是order消息");
        rabbitTemplate.convertAndSend("rabbitmq-java-exchange","hello.rabbitmq",orderEntity);
        log.info("向交换机rabbitmq-java-exchange绑定路由键hello.rabbitmq消息");
    }

    // ------------------------------------------------------------------------------------------
    // route
    @Test
    void route(){
        String keys[] = {"error","info"};
        for (int i = 0; i < 10; i++) {
            int i1 = new Random().nextInt(2);
            rabbitTemplate.convertAndSend("direct",keys[i1],"msg~~"+keys[i1]);
        }
    }

    // fanout
    @Test
    void fanout(){
        String keys[] = {"error","info"};
        for (int i = 0; i < 10; i++) {
            int i1 = new Random().nextInt(1);
            rabbitTemplate.convertAndSend("logs",keys[i1],"msg"+i);
        }
    }

    @Test
    void work(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","msg"+i);
        }
    }

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("hello","~~~RabbitmqDemoApplicationTests~~~");
    }

}
