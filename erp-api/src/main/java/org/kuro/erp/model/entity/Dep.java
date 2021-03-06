package org.kuro.erp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.houkunlin.system.dict.starter.json.DictText;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "t_dep")
public class Dep implements Serializable {

    @Id
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "部门电话")
    private String tele;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "描述")
    private String description;

    @DictText("status")
    @ApiModelProperty(value = "状态，0启用，1禁用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date updateTime;
}
