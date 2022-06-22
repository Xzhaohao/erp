package org.kuro.erp.service;

import org.kuro.erp.model.bo.SaveSupplierBo;
import org.kuro.erp.model.entity.Supplier;
import org.kuro.erp.model.page.PageResult;

import java.util.List;

public interface SupplierService {


    /**
     * 根据条件查询供应商列表
     *
     * @param page    当前页
     * @param limit   每页显示条数
     * @param name    供应商公司
     * @param contact 联系人
     * @param mobile  手机号
     * @param needs   送货方式，1送货，2自提
     * @return 供应商列表
     */
    PageResult<Supplier> supplierList(
            Integer page, Integer limit,
            String name, String contact, String mobile, Integer needs
    );


    /**
     * 获取全部供应商公司名称
     *
     * @return 全部供应商公司名称
     */
    List<String> allSupplier();


    /**
     * 添加供应商
     *
     * @param bo 参数
     */
    void saveSupplier(SaveSupplierBo bo);


    /**
     * 根据供应商名称查询供应商信息
     *
     * @param SupplierName 供应商名称
     * @return 供应商信息
     */
    Supplier queryByName(String SupplierName);
}
