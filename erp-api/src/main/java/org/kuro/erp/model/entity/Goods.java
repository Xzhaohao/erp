package org.kuro.erp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.houkunlin.system.dict.starter.json.DictText;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "t_goods")
public class Goods {

    @Id
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "商品类别名称")
    private String name;

    @ApiModelProperty(value = "产地")
    private String origin;

    @ApiModelProperty(value = "生产厂家")
    private String producer;

    @ApiModelProperty(value = "单位")
    private String unit;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "进货价")
    private BigDecimal inPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "销售价")
    private BigDecimal outPrice;

    @ApiModelProperty(value = "商品类别ID")
    private String goodsTypeId;

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
