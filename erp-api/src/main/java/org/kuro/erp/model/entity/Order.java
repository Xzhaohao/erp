package org.kuro.erp.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_order")
public class Order {

    @Id
    @ApiModelProperty(value = "主键")
    private String id;


}
