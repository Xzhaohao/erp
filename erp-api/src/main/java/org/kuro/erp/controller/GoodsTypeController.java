package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.entity.GoodsType;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goodsType")
@Api(value = "商品类别模块", tags = "商品类别")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;


    @ApiOperation(value = "商品类别列表", notes = "根据条件查询商品类别列表")
    @GetMapping("/list")
    public Result goodsTypeListApi(
            @ApiParam(name = "page", value = "当前页", defaultValue = "1")
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @ApiParam(name = "limit", value = "每页显示条数", defaultValue = "10")
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @ApiParam(name = "name", value = "商品类别名称")
            @RequestParam(value = "name", required = false) String name,
            @ApiParam(name = "supplierName", value = "手机号")
            @RequestParam(value = "supplierName", required = false) String supplierName
    ) {
        PageResult<GoodsType> result = goodsTypeService.goodsTypeList(page, limit, name, supplierName);
        return Result.ok().data(result);
    }
}
