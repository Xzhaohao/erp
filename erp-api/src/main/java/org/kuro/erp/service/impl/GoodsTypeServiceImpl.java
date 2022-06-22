package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.GoodsTypeMapper;
import org.kuro.erp.model.entity.GoodsType;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;


    @Override
    public PageResult<GoodsType> goodsTypeList(
            Integer page, Integer limit, String name, String supplierName
    ) {
        PageHelper.startPage(page, limit);
        List<GoodsType> list = goodsTypeMapper.selectGoodsTypeList(name, supplierName);
        PageInfo<GoodsType> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }
}
