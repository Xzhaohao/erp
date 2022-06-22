package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.GoodsMapper;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.vo.GoodsVo;
import org.kuro.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public PageResult<GoodsVo> goodsList(
            Integer page, Integer limit, String name,
            String supplierName, String producer, String unit,
            BigDecimal minInPrice, BigDecimal maxInPrice,
            BigDecimal minOutPrice, BigDecimal maxOutPrice
    ) {
        PageHelper.startPage(page, limit);

        List<GoodsVo> list = goodsMapper.selectGoodsList(
                supplierName, name, producer,
                unit, minInPrice, maxInPrice,
                minOutPrice, maxOutPrice
        );

        PageInfo<GoodsVo> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }
}
