package org.kuro.erp.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kuro.erp.model.result.ResultCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "错误信息")
    private String errMsg;

    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.errMsg = resultCode.getMessage();
    }
}
