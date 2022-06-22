package org.kuro.erp.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kuro.erp.model.entity.Goods;
import org.kuro.erp.model.entity.GoodsType;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsVo extends Goods {

    private GoodsType goodsType;
}
