package org.kuro.erp.service;

import org.kuro.erp.model.entity.Order;
import org.kuro.erp.model.page.PageResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService {

    /**
     * 查询订单列表
     *
     * @param orderType     订单类型
     * @param page          当前页
     * @param limit         每页显示条数
     * @param orderState    订单状态
     * @param creater       下单人
     * @param minTotal      最小总量
     * @param maxTotal      最大总量
     * @param minCreateTime 最小下单时间
     * @param maxCreateTime 最大下单时间
     * @param minOrderPrice 最小总额
     * @param maxOrderPrice 最大总额
     * @return 订单列表
     */
    PageResult<Order> queryOrderList(
            Integer orderType, Integer page, Integer limit,
            Integer orderState, String creater, Integer minTotal,
            Integer maxTotal, Date minCreateTime, Date maxCreateTime,
            BigDecimal minOrderPrice, BigDecimal maxOrderPrice
    );
}
