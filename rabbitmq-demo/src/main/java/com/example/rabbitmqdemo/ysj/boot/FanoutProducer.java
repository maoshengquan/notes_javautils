package com.example.rabbitmqdemo.ysj.boot;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/3 0003
 * //TODO
 */
@RestController
public class FanoutProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @return
     */
    @RequestMapping("/sendMsg")
    public String sendMsg(String msg) {
        /**
         * 1.交换机名称
         * 2.路由key名称
         * 3.发送内容
         */
        amqpTemplate.convertAndSend("/mayikt_ex", "", msg);
        return "success";
    }
}