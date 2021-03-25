package com.msq.shop.producer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.msq.api.IUserService;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.producer.service.UserServiceImpl
 * @description
 * @date 2021/3/19 0019
 * //TODO
 */
@Component
@Service(interfaceClass =IUserService.class )
public class UserServiceImpl implements IUserService {

    @Override
    public String sayHello(String name) {
        return "producer: "+name;
    }
}
