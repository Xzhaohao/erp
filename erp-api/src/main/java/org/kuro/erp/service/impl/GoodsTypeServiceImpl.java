package org.kuro.erp.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.exceptions.BusinessException;
import org.kuro.erp.mapper.GoodsTypeMapper;
import org.kuro.erp.model.bo.GoodsTypeBo;
import org.kuro.erp.model.entity.GoodsType;
import org.kuro.erp.model.entity.Supplier;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.service.GoodsTypeService;
import org.kuro.erp.service.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Autowired
    private SupplierService supplierService;


    @Override
    public PageResult<GoodsType> goodsTypeList(
            Integer page, Integer limit, String name, String supplierName
    ) {
        PageHelper.startPage(page, limit);
        List<GoodsType> list = goodsTypeMapper.selectGoodsTypeList(name, supplierName);
        PageInfo<GoodsType> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }


    @Override
    public void saveGoodsType(GoodsTypeBo bo) {
        // 查询商品类别是否重复
        Integer count = goodsTypeMapper.selectByNameAndSupplier(bo.getName(), bo.getSupplierName());
        if (count > 0) {
            throw new BusinessException(ResultCode.CAN_NOT_REPEAT_ADD);
        }

        GoodsType goodsType = new GoodsType();
        BeanUtils.copyProperties(bo, goodsType);

        goodsType.setId(IdUtil.getSnowflakeNextIdStr());
        goodsType.setCreateTime(new Date());

        Supplier supplier = supplierService.queryByName(bo.getSupplierName());
        goodsType.setSupplierId(supplier.getId());

        goodsTypeMapper.insertSelective(goodsType);
    }


    @Override
    public void updateGoodsType(GoodsType goodsType) {
        goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
    }


    @Override
    public void deleteById(String id) {
        goodsTypeMapper.deleteByPrimaryKey(id);
    }
}
