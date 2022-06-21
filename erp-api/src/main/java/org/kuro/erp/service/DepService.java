package org.kuro.erp.service;

import org.kuro.erp.model.entity.Dep;
import org.kuro.erp.model.page.PageResult;

import java.util.List;

public interface DepService {

    /**
     * 条件查询部门信息
     *
     * @param page    当前页
     * @param limit   每页显示条数
     * @param depName 部门名称
     * @param tele    部门电话
     * @return 部门分页信息列表
     */
    PageResult<Dep> depList(Integer page, Integer limit, String depName, String tele);


    /**
     * 获取所有可用部门
     *
     * @return 部门列表
     */
    List<String> allDep();
}
