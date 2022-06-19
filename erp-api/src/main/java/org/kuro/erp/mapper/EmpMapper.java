package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Emp;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmpMapper extends Mapper<Emp> {

    List<Emp> selectEmpList(
            @Param("name") String name, @Param("mobile") String mobile,
            @Param("gender") Integer gender, @Param("depName") String depName
    );
}
