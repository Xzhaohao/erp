package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Goods;
import org.kuro.erp.model.vo.GoodsVo;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsMapper extends Mapper<Goods> {

    List<GoodsVo> selectGoodsList(
            @Param("supplierName") String supplierName, @Param("name") String name,
            @Param("producer") String producer, @Param("unit") String unit,
            @Param("minInPrice") BigDecimal minInPrice, @Param("maxInPrice") BigDecimal maxInPrice,
            @Param("minOutPrice") BigDecimal minOutPrice, @Param("maxOutPrice") BigDecimal maxOutPrice
    );
}
