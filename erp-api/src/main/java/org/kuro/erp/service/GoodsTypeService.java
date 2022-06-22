package org.kuro.erp.service;

import org.kuro.erp.model.bo.GoodsTypeBo;
import org.kuro.erp.model.entity.GoodsType;
import org.kuro.erp.model.page.PageResult;

public interface GoodsTypeService {

    /**
     * 获取商品列表数据
     *
     * @param page         当前页
     * @param limit        每页显示条数
     * @param name         商品类别名称
     * @param supplierName 供应商名称
     * @return 商品列表
     */
    PageResult<GoodsType> goodsTypeList(Integer page, Integer limit, String name, String supplierName);


    /**
     * 添加商品类别
     *
     * @param bo 参数
     */
    void saveGoodsType(GoodsTypeBo bo);


    /**
     * 修改商品类别
     *
     * @param goodsType 参数
     */
    void updateGoodsType(GoodsType goodsType);


    /**
     * 根据ID删除商品类别
     *
     * @param id 主键
     */
    void deleteById(String id);
}
