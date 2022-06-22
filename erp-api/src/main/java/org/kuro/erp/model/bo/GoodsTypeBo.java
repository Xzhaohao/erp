package org.kuro.erp.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "GoodsTypeBo对象", description = "添加商品类别参数")
public class GoodsTypeBo {

    @NotBlank(message = "请填写商品类别名称！")
    @ApiModelProperty(value = "商品类别名称")
    private String name;

    @NotBlank(message = "请选择供应商！")
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
}
