package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.erp.model.bo.QueryOrderBo;
import org.kuro.erp.model.entity.Order;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
@Api(value = "订单模块", tags = "订单模块")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "订单列表", notes = "根据条件查询订单列表")
    @PostMapping("/list/{type}")
    public Result fetchOrderListApi(
            @PathVariable(name = "type") Integer orderType,
            @RequestBody @Valid QueryOrderBo bo
    ) {
        PageResult<Order> list = orderService.queryOrderList(
                orderType, bo.getPage(), bo.getLimit(), bo.getOrderState(),
                bo.getCreater(), bo.getMinTotal(), bo.getMaxTotal(), bo.getMinCreateTime(),
                bo.getMaxCreateTime(), bo.getMinOrderPrice(), bo.getMaxOrderPrice()
        );
        return Result.ok().data(list);
    }
}
