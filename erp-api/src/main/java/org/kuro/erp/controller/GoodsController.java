package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.model.vo.GoodsVo;
import org.kuro.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/goods")
@Api(value = "商品管理模块", tags = "商品管理")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "商品列表", notes = "根据条件查询商品列表")
    @GetMapping("/list")
    public Result goodsListApi(
            @ApiParam(name = "page", value = "当前页", defaultValue = "1")
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,

            @ApiParam(name = "limit", value = "每页显示条数", defaultValue = "10")
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,

            @ApiParam(name = "name", value = "商品名称")
            @RequestParam(value = "name", required = false) String name,

            @ApiParam(name = "supplierName", value = "供应商")
            @RequestParam(value = "supplierName", required = false) String supplierName,

            @ApiParam(name = "producer", value = "生产厂家")
            @RequestParam(value = "producer", required = false) String producer,

            @ApiParam(name = "unit", value = "单位")
            @RequestParam(value = "unit", required = false) String unit,

            @ApiParam(name = "minInPrice", value = "最小进货价")
            @RequestParam(value = "minInPrice", required = false) BigDecimal minInPrice,

            @ApiParam(name = "maxInPrice", value = "最大进货价")
            @RequestParam(value = "maxInPrice", required = false) BigDecimal maxInPrice,

            @ApiParam(name = "minOutPrice", value = "最小销售价")
            @RequestParam(value = "minOutPrice", required = false) BigDecimal minOutPrice,

            @ApiParam(name = "maxOutPrice", value = "最大销售价")
            @RequestParam(value = "maxOutPrice", required = false) BigDecimal maxOutPrice
    ) {
        PageResult<GoodsVo> result = goodsService.goodsList(
                page, limit, name, supplierName,
                producer, unit, minInPrice,
                maxInPrice, minOutPrice, maxOutPrice
        );
        return Result.ok().data(result);
    }
}
