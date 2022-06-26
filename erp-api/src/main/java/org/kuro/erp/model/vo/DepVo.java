package org.kuro.erp.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kuro.erp.model.entity.Dep;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepVo extends Dep {

    private Integer empCount;
}
