package org.kuro.erp.model.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "QueryOrderBo对象", description = "查询订单的参数")
public class QueryOrderBo {

    @NotNull(message = "当前页不能为空！")
    private Integer page;

    @NotNull(message = "每页显示条数不能为空！")
    private Integer limit;

    private Integer orderState;

    private String creater;

    private Integer minTotal;
    private Integer maxTotal;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date minCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date maxCreateTime;

    private BigDecimal minOrderPrice;
    private BigDecimal maxOrderPrice;
}
