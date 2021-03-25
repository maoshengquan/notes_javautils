package com.msq.shop.order.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.msq.shop.api.IOrderService;
import com.msq.shop.entity.Result;
import com.msq.shop.pojo.TradeOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.shop.order.web.OrderTestWebApplication
 * @description
 * @date 2021/3/21 0021
 * //TODO
 */
@SpringBootTest(classes = OrderWebApplication.class)
public class OrderTestWebApplication {

    @Reference
    private IOrderService orderService;

    @Test
    void order(){
        Long coupouId = 345988230098857984L;
        Long goodsId = 345959443973935104L;
        Long userId = 345963634385633280L;

        TradeOrder order = new TradeOrder();
        order.setGoodsId(goodsId);
        order.setUserId(userId);
        order.setCouponId(coupouId);
        order.setAddress("北京");
        order.setGoodsNumber(1);
        order.setGoodsPrice(new BigDecimal(5000.00));
        order.setShippingFee(BigDecimal.ZERO);
        order.setOrderAmount(new BigDecimal(5000));
        order.setMoneyPaid(new BigDecimal(100));

        Result result = orderService.confirmOrder(order);
        System.out.println(result);

    }

}
