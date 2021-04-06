package com.example.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest(classes = RabbitmqDemoApplication.class )
class RabbitmqDemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //route
    @Test
    void route(){
        String keys[] = {"error","info"};
        for (int i = 0; i < 10; i++) {
            int i1 = new Random().nextInt(2);
            rabbitTemplate.convertAndSend("direct",keys[i1],"msg~~"+keys[i1]);
        }
    }

    //fanout
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
