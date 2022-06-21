package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Dep;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DepMapper extends Mapper<Dep> {

    List<Dep> selectDepList(@Param("tele") String tele, @Param("depName") String depName);

    List<String> selectAllNormal();
}
