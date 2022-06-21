package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Supplier;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SupplierMapper extends Mapper<Supplier> {

    List<Supplier> selectSupplierList(
            @Param("name") String name, @Param("contact") String contact,
            @Param("mobile") String mobile, @Param("needs") Integer needs
    );


    List<String> selectSupplierAll();
}
