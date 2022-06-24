package org.kuro.erp.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.erp.model.bo.LoginFromBo;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.result.Result;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.model.vo.EmpVo;
import org.kuro.erp.service.EmpService;
import org.kuro.erp.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sys")
@Api(value = "登陆模块", tags = "登陆相关")
public class PassportController {

    @Autowired
    private EmpService empService;

    @ApiOperation(value = "登陆", notes = "登陆")
    @PostMapping("/login")
    public Result loginApi(@RequestBody @Valid LoginFromBo bo) {
        Emp user = empService.queryEmpByMobile(bo.getMobile());
        // 用户不存在
        if (user == null) {
            return Result.error(ResultCode.ACCOUNT_INFO_ERROR);
        }

        // 密码错误
        boolean isMatch = BCrypt.checkpw(bo.getPassword(), user.getPassword());
        if (!isMatch) {
            return Result.error(ResultCode.ACCOUNT_INFO_ERROR);
        }

        // 员工离职
        if (user.getState() == 2) {
            return Result.error(ResultCode.ACCOUNT_NOT_EXIST);
        }

        // todo 登陆次数 +1，记录登陆IP，登陆时间

        StpUtil.login(user.getId());
        SaSession session = StpUtil.getSession();
        session.set(RedisKeyUtil.getSessionUserKey(), user);
        SaTokenInfo info = StpUtil.getTokenInfo();
        return Result.ok(ResultCode.LOGIN_SUCCESS).data("token", info.tokenValue);
    }


    @ApiOperation(value = "登陆信息", notes = "获取登陆用户信息")
    @GetMapping("/profile")
    public Result profileApi() {
        String loginUserID = StpUtil.getLoginIdAsString();
        EmpVo user = empService.queryEmpById(loginUserID);
        // SaSession session = StpUtil.getSession();
        // Emp user = (Emp) session.get(RedisKeyUtil.getSessionUserKey());
        return Result.ok().data(user);
    }


    @ApiOperation(value = "退出登陆", notes = "退出登陆")
    @PostMapping("/logout")
    public Result logoutApi() {
        StpUtil.logout();
        return Result.ok(ResultCode.LOGOUT_SUCCESS);
    }
}
