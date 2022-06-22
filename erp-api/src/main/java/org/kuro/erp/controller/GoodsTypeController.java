package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.bo.GoodsTypeBo;
import org.kuro.erp.model.entity.GoodsType;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            @ApiParam(name = "supplierName", value = "供应商")
            @RequestParam(value = "supplierName", required = false) String supplierName
    ) {
        PageResult<GoodsType> result = goodsTypeService.goodsTypeList(page, limit, name, supplierName);
        return Result.ok().data(result);
    }


    @ApiOperation(value = "添加商品类别", notes = "添加商品类别")
    @PostMapping("/save")
    public Result saveGoodsTypeApi(@RequestBody @Valid GoodsTypeBo bo) {
        goodsTypeService.saveGoodsType(bo);
        return Result.ok(ResultCode.ADD_SUCCESS);
    }


    @ApiOperation(value = "修改商品类别", notes = "修改商品类别")
    @PutMapping("/update")
    public Result updateGoodsTypeApi(@RequestBody @Valid GoodsType goodsType) {
        goodsTypeService.updateGoodsType(goodsType);
        return Result.ok(ResultCode.UPDATE_SUCCESS);
    }


    @ApiOperation(value = "删除商品类别", notes = "删除商品类别")
    @DeleteMapping("/delete/{id}")
    public Result deleteGoodsTypeApi(@PathVariable(name = "id") String id) {
        goodsTypeService.deleteById(id);
        return Result.ok(ResultCode.DELETE_SUCCESS);
    }
}
