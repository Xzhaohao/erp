package org.kuro.erp.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(value = "SaveEmpBo对象", description = "添加员工参数")
public class SaveEmpBo {

    @NotBlank(message = "请填写民族！")
    @ApiModelProperty(value = "民族")
    private String nation;

    @NotBlank(message = "密码不能为空！")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "确认密码不能为空！")
    @ApiModelProperty(value = "确认密码")
    private String password2;

    @NotBlank(message = "姓名不能为空！")
    @ApiModelProperty(value = "姓名")
    private String name;

    @NotBlank(message = "邮箱不能为空！")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @NotBlank(message = "手机号不能为空！")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @NotBlank(message = "地址不能为空！")
    @ApiModelProperty(value = "地址")
    private String address;

    @NotNull(message = "请选择员工性别！")
    @ApiModelProperty(value = "1男，2女")
    private Integer gender;

    @NotNull(message = "请填写生日！")
    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "部门ID")
    private String depId;

    @NotBlank(message = "请选择部门！")
    @ApiModelProperty(value = "部门名称")
    private String depName;
}
