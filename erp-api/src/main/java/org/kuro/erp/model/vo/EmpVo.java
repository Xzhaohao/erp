package org.kuro.erp.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.entity.Role;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmpVo extends Emp {

    @ApiModelProperty(value = "角色")
    private List<Role> roles;

    @ApiModelProperty(value = "权限")
    private EmpPermission permission;
}
