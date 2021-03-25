package com.msq.shop.api;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.api.ICouponService
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */

import com.msq.shop.entity.Result;
import com.msq.shop.pojo.TradeCoupon;

/**
 * 优惠券接口
 */
public interface ICouponService {


    /**
     * 根据ID查询优惠券对象
     * @param coupouId
     * @return
     */
    public TradeCoupon findOne(Long coupouId);

    /**
     * 更细优惠券状态
     * @param coupon
     * @return
     */
    Result updateCouponStatus(TradeCoupon coupon);
}
