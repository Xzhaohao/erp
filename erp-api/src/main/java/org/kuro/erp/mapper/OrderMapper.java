package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Order;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderMapper extends Mapper<Order> {

    List<Order> selectListByParams(
            @Param("orderType") Integer orderType, @Param("orderState") Integer orderState,
            @Param("creater") String creater, @Param("minTotal") Integer minTotal,
            @Param("maxTotal") Integer maxTotal, @Param("minCreateTime") Date minCreateTime,
            @Param("maxCreateTime") Date maxCreateTime, @Param("minOrderPrice") BigDecimal minOrderPrice,
            @Param("maxOrderPrice") BigDecimal maxOrderPrice
    );
}
