package com.msq.shop.config;

import com.itheima.utils.IDWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.order.config.OrderConfig
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@Configuration
public class OrderServiceConfig {

    // 雪花算法-生成ID
    @Bean
    public IDWorker idWorker(){
        return new IDWorker(2,3);
    }

}
