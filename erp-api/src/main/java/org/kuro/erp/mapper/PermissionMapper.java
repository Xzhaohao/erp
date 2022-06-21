package org.kuro.erp.mapper;

import org.kuro.erp.model.entity.Permission;
import org.kuro.erp.model.vo.PermissionVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<PermissionVo> selectPermissionList();
}
