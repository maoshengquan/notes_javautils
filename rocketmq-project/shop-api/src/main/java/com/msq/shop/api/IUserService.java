package com.msq.shop.api;

import com.msq.shop.entity.Result;
import com.msq.shop.pojo.TradeUser;
import com.msq.shop.pojo.TradeUserMoneyLog;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.api.IUserService
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
public interface IUserService {
    TradeUser findOne(Long userId);

    Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog);
}
