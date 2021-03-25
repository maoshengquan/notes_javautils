package com.msq.shop;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.OrderServiceApplication
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@EnableDubboConfiguration
@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class,args);
    }

}
