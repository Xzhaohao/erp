package org.kuro.erp.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "SavaSupplierBo对象", description = "供应商参数")
public class SupplierBo {

    @ApiModelProperty(value = "ID")
    private String id;

    @NotBlank(message = "请填写供应商公司名称！")
    @ApiModelProperty(value = "供应商公司名称")
    private String name;

    @NotBlank(message = "请填写公司地址！")
    @ApiModelProperty(value = "供应商公司地址")
    private String address;

    @NotBlank(message = "联系人不能为空！")
    @ApiModelProperty(value = "联系人")
    private String contact;

    @NotBlank(message = "联系方式不能为空！")
    @ApiModelProperty(value = "联系方式")
    private String mobile;

    @NotNull(message = "请选择是否送货！")
    @ApiModelProperty(value = "是否送货，1送货，2自提")
    private Integer needs;
}
