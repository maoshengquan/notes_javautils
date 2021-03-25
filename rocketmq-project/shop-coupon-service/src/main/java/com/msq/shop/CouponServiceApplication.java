package com.msq.shop;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.CouponServiceApplication
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@EnableDubboConfiguration
@SpringBootApplication
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class,args);
    }

}
