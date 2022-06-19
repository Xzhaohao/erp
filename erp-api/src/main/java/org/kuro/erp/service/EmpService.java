package org.kuro.erp.service;

import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.page.PageResult;

public interface EmpService {

    /**
     * 查询员工列表
     *
     * @param page    当前页
     * @param limit   每页显示条数
     * @param name    姓名
     * @param mobile  手机号
     * @param gender  性别
     * @param depName 部门名称
     * @return 员工列表
     */
    PageResult<Emp> queryEmpList(
            Integer page, Integer limit, String name, String mobile,
            Integer gender, String depName
    );
}