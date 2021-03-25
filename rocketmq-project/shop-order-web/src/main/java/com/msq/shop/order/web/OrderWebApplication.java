package com.msq.shop.order.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.order.web
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@EnableDubboConfiguration
@SpringBootApplication
public class OrderWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderWebApplication.class,args);

    }

}
