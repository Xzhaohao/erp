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
@Table(name = "t_order")
public class Order {

    @Id
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "订单编号")
    private String orderNum;

    @ApiModelProperty(value = "创建人ID")
    private String createrId;

    @ApiModelProperty(value = "订单创建人")
    private String creater;

    @DictText("order_type")
    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @DictText("order_state")
    @ApiModelProperty(value = "订单状态")
    private Integer orderState;

    @ApiModelProperty(value = "订单商品总数")
    private Integer total;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "订单商品总价")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "审核人ID")
    private String checkerId;

    @ApiModelProperty(value = "订单审核人")
    private String checker;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "审核时间")
    private Date checkerTime;

    @ApiModelProperty(value = "订单负责人ID")
    private String completerId;

    @ApiModelProperty(value = "订单负责人")
    private String completer;

    @ApiModelProperty(value = "供应商ID")
    private String supplierId;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "订单结束时间")
    private Date endTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "订单修改时间")
    private Date updateTime;
}
