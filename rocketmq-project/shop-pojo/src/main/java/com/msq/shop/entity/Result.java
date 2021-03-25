package com.msq.shop.entity;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.entity.Result
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */

import lombok.*;

import java.io.Serializable;

/**
 * 结果实体类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private Boolean success;
    private String message;
}
