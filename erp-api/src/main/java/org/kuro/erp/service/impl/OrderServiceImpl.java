package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.OrderMapper;
import org.kuro.erp.model.entity.Order;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public PageResult<Order> queryOrderList(
            Integer orderType, Integer page, Integer limit,
            Integer orderState, String creater, Integer minTotal,
            Integer maxTotal, Date minCreateTime, Date maxCreateTime,
            BigDecimal minOrderPrice, BigDecimal maxOrderPrice
    ) {
        PageHelper.startPage(page, limit);
        List<Order> list = orderMapper.selectListByParams(
                orderType, orderState, creater, minTotal,
                maxTotal, minCreateTime, maxCreateTime,
                minOrderPrice, maxOrderPrice
        );

        PageInfo<Order> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }
}
