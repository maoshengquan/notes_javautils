package com.example.rabbitmqdemo.entity;

import lombok.Data;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/5 0005
 * //TODO
 */
@Data
public class OrderEntity {

    private Integer orderId;
    private String msg;

    public OrderEntity(Integer orderId, String msg) {
        this.orderId = orderId;
        this.msg = msg;
    }

    public OrderEntity() {
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", msg='" + msg + '\'' +
                '}';
    }
}
