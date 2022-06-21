package org.kuro.erp.mapper;

import org.kuro.erp.model.entity.EmpRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmpRoleMapper extends Mapper<EmpRole> {

    List<EmpRole> selectEmpRoleByEmpId(String empId);

    /**
     * 根据用户ID删除
     *
     * @param empId 用户ID
     */
    void deleteByEmpId(String empId);
}
