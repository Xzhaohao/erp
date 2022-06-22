package org.kuro.erp.service;

import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.vo.GoodsVo;

import java.math.BigDecimal;

public interface GoodsService {

    /**
     * 获取商品列表
     *
     * @param page         当前页
     * @param limit        每页显示条数
     * @param name         商品名称
     * @param supplierName 供应商
     * @param producer     生产厂家
     * @param unit         单位
     * @param minInPrice   最小进货价
     * @param maxInPrice   最大进货价
     * @param minOutPrice  最小销售价
     * @param maxOutPrice  最大销售价
     * @return 商品列表
     */
    PageResult<GoodsVo> goodsList(
            Integer page, Integer limit, String name,
            String supplierName, String producer, String unit,
            BigDecimal minInPrice, BigDecimal maxInPrice,
            BigDecimal minOutPrice, BigDecimal maxOutPrice
    );
}
