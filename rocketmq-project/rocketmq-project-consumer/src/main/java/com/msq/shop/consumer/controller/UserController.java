package com.msq.shop.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msq.api.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.consumer.controller.UserController
 * @description
 * @date 2021/3/19 0019
 * //TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return userService.sayHello(name);
    }

}
