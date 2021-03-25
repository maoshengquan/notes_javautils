package com.msq.shop.api;

import com.msq.shop.entity.Result;
import com.msq.shop.pojo.TradeOrder;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.api.IOrderService
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
public interface IOrderService {
    /**
     * 确认订单
     * @param order
     * @return Result
     */
    Result confirmOrder(TradeOrder order);
}
