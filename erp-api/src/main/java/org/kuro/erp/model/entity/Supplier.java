package org.kuro.erp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.houkunlin.system.dict.starter.json.DictText;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_supplier")
public class Supplier {

    @Id
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "供应商公司名称")
    private String name;

    @ApiModelProperty(value = "供应商公司地址")
    private String address;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @DictText("needs")
    @ApiModelProperty(value = "是否送货，1送货，2自提")
    private Integer needs;

    @DictText("del_flag")
    @ApiModelProperty(value = "状态，0正常，1删除")
    private Integer delFlag;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date updateTime;
}
