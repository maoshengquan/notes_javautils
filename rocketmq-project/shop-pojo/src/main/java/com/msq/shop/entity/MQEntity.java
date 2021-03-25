package com.msq.shop.entity;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.entity.MQEntity
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MQEntity {

    private Long orderId;
    private Long couponId;
    private Long userId;
    private BigDecimal userMoney;
    private Long goodsId;
    private Integer goodsNum;

}
