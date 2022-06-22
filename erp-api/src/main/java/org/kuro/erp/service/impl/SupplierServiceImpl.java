package org.kuro.erp.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.SupplierMapper;
import org.kuro.erp.model.bo.SaveSupplierBo;
import org.kuro.erp.model.entity.Supplier;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.service.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;


    @Override
    public PageResult<Supplier> supplierList(
            Integer page, Integer limit,
            String name, String contact, String mobile, Integer needs
    ) {
        PageHelper.startPage(page, limit);
        List<Supplier> suppliers = supplierMapper.selectSupplierList(name, contact, mobile, needs);
        PageInfo<Supplier> info = new PageInfo<>(suppliers);
        return new PageResult<>(info.getTotal(), suppliers);
    }


    @Override
    public List<String> allSupplier() {
        return supplierMapper.selectSupplierAll();
    }


    @Override
    public void saveSupplier(SaveSupplierBo bo) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(bo, supplier);

        supplier.setId(IdUtil.getSnowflakeNextIdStr());
        supplier.setCreateTime(new Date());

        supplierMapper.insertSelective(supplier);
    }


    @Override
    public Supplier queryByName(String SupplierName) {
        return supplierMapper.selectByName(SupplierName);
    }
}
