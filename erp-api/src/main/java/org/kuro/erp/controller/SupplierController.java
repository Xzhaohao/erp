package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.bo.SupplierBo;
import org.kuro.erp.model.entity.Supplier;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Api(value = "供应商管理模块", tags = "供应商")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @ApiOperation(value = "供应商列表", notes = "根据条件查询供应商列表")
    @GetMapping("/list")
    public Result supplierListApi(
            @ApiParam(name = "page", value = "当前页", defaultValue = "1")
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @ApiParam(name = "limit", value = "每页显示条数", defaultValue = "10")
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @ApiParam(name = "name", value = "供应商公司")
            @RequestParam(value = "name", required = false) String name,
            @ApiParam(name = "mobile", value = "手机号")
            @RequestParam(value = "mobile", required = false) String mobile,
            @ApiParam(name = "contact", value = "联系人")
            @RequestParam(value = "contact", required = false) String contact,
            @ApiParam(name = "needs", value = "是否送货")
            @RequestParam(value = "needs", required = false) Integer needs
    ) {
        PageResult<Supplier> result = supplierService.supplierList(
                page, limit, name, contact, mobile, needs
        );
        return Result.ok().data(result);
    }


    @ApiOperation(value = "全部供应商", notes = "查询全部供应商")
    @GetMapping("/all")
    public Result allSupplierApi() {
        List<String> suppliers = supplierService.allSupplier();
        return Result.ok().data(suppliers);
    }


    @ApiOperation(value = "添加供应商", notes = "添加供应商")
    @PostMapping("/save")
    public Result saveSupplierApi(@RequestBody @Valid SupplierBo bo) {
        supplierService.saveSupplier(bo);
        return Result.ok(ResultCode.ADD_SUCCESS);
    }


    @ApiOperation(value = "修改供应商", notes = "修改供应商")
    @PutMapping("/update")
    public Result updateSupplierApi(@RequestBody @Valid SupplierBo bo) {
        supplierService.updateSupplier(bo);
        return Result.ok(ResultCode.UPDATE_SUCCESS);
    }


    @ApiOperation(value = "删除供应商", notes = "删除供应商")
    @DeleteMapping("/delete/{id}")
    public Result deleteSupplierApi(@PathVariable(name = "id") String id) {
        return Result.ok(ResultCode.DELETE_SUCCESS);
    }
}
