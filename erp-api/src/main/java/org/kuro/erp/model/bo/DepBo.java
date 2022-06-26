package org.kuro.erp.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "DepBo对象", description = "添加/修改部门参数")
public class DepBo {

    @ApiModelProperty(value = "ID")
    private String id;

    @NotBlank(message = "部门名称不能为空！")
    @ApiModelProperty(value = "部门名称")
    private String name;

    @NotBlank(message = "电话不能为空！")
    @ApiModelProperty(value = "电话")
    private String tele;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "描述")
    private String description;
}
