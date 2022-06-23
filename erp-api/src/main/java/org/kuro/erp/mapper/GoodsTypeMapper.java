package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.GoodsType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsTypeMapper extends Mapper<GoodsType> {

    List<GoodsType> selectGoodsTypeList(
            @Param("name") String name, @Param("supplierName") String supplierName
    );

    Integer selectByNameAndSupplier(
            @Param("name") String name, @Param("supplierName") String supplierName
    );

    List<String> selectAllBySupplier(@Param("supplierName") String supplierName);
}
