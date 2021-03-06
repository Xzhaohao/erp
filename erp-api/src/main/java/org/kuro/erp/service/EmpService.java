package org.kuro.erp.service;

import org.kuro.erp.model.bo.SaveEmpBo;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.vo.EmpVo;

public interface EmpService {

    /**
     * 根据手机号查询员工
     *
     * @param mobile 手机号
     * @return 员工信息
     */
    Emp queryEmpByMobile(String mobile);


    /**
     * 根据ID查询员工
     *
     * @param id ID
     * @return 员工VO信息
     */
    EmpVo queryEmpById(String id);


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
    PageResult<EmpVo> queryEmpList(
            Integer page, Integer limit, String name, String mobile,
            Integer gender, String depName
    );


    /**
     * 新增员工
     *
     * @param bo 员工参数
     */
    void save(SaveEmpBo bo);


    /**
     * 修改员工
     *
     * @param bo 员工参数
     */
    void update(Emp bo);


    /**
     * 查询指定部门有多少员工
     *
     * @param depId 部门ID
     * @return 部门下的员工数量
     */
    Integer empDepNum(String depId);
}
