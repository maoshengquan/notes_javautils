package com.example.rabbitmqdemo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/5 0005
 * //TODO
 */
@ToString
@Data
public class UserEntity implements Serializable {

    private Integer id;
    private String msg;

    public UserEntity(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public UserEntity() {
    }
}
