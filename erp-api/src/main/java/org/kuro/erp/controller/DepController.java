package org.kuro.erp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kuro.erp.model.entity.Dep;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dep")
@Api(value = "部门管理模块", tags = "部门管理")
public class DepController {

    @Autowired
    private DepService depService;

    @ApiOperation(value = "部门列表", notes = "根据条件查询部门列表")
    @GetMapping("/list")
    public Result depListApi(
            @ApiParam(name = "page", value = "当前页", defaultValue = "1")
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @ApiParam(name = "limit", value = "每页显示条数", defaultValue = "10")
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @ApiParam(name = "depName", value = "部门名称")
            @RequestParam(value = "depName", required = false) String depName,
            @ApiParam(name = "tele", value = "部门座机")
            @RequestParam(value = "tele", required = false) String tele
    ) {
        PageResult<Dep> result = depService.depList(page, limit, depName, tele);
        return Result.ok().data(result);
    }


    @ApiOperation(value = "所有部门", notes = "获取所有状态正常的部门")
    @GetMapping("/all")
    public Result allDepApi() {
        List<Dep> deps = depService.allDep();
        return Result.ok().data(deps);
    }
}
