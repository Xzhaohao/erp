package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.bo.SaveEmpBo;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.model.vo.EmpVo;
import org.kuro.erp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/emp")
@Api(value = "员工管理模块", tags = "员工管理")
public class EmpController {

    @Autowired
    private EmpService empService;

    @ApiOperation(value = "员工列表", notes = "根据条件查询员工列表")
    @GetMapping("/list")
    public Result empApi(
            @ApiParam(name = "page", value = "当前页", defaultValue = "1")
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @ApiParam(name = "limit", value = "每页显示条数", defaultValue = "10")
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @ApiParam(name = "name", value = "姓名")
            @RequestParam(value = "name", required = false) String name,
            @ApiParam(name = "mobile", value = "手机号")
            @RequestParam(value = "mobile", required = false) String mobile,
            @ApiParam(name = "gender", value = "性别")
            @RequestParam(value = "gender", required = false) Integer gender,
            @ApiParam(name = "depName", value = "部门名称")
            @RequestParam(value = "depName", required = false) String depName
    ) {
        PageResult<EmpVo> result = empService.queryEmpList(page, limit, name, mobile, gender, depName);
        return Result.ok().data(result);
    }


    @ApiOperation(value = "添加员工", notes = "添加员工")
    @PostMapping("/save")
    public Result saveEmpApi(@RequestBody @Valid SaveEmpBo bo) {
        // 两次密码不一致
        if (!bo.getPassword().equals(bo.getPassword2())) {
            return Result.error(ResultCode.PASSWORD_NOT_ALIKE);
        }

        empService.save(bo);

        return Result.ok(ResultCode.ADD_SUCCESS);
    }


    @ApiOperation(value = "修改员工", notes = "修改员工信息")
    @PutMapping("/update")
    public Result updateEmpApi(@RequestBody @Valid Emp emp) {
        empService.update(emp);
        return Result.ok(ResultCode.UPDATE_SUCCESS);
    }
}
