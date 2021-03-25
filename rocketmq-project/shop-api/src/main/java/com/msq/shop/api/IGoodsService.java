package com.msq.shop.api;

import com.msq.shop.entity.Result;
import com.msq.shop.pojo.TradeGoods;
import com.msq.shop.pojo.TradeGoodsNumberLog;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.api.IGoodsService
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
public interface IGoodsService {

    /**
     * 根据ID查询商品对象
     * @param goodsId
     * @return
     */
    TradeGoods findOne(Long goodsId);

    /**
     * 扣减库存
     * @param goodsNumberLog
     * @return
     */
    Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog);

}
