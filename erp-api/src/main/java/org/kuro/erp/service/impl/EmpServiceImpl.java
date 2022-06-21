package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.EmpMapper;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp queryEmpByMobile(String mobile) {
        return empMapper.selectEmpByMobile(mobile);
    }


    @Override
    public Emp queryEmpById(String id) {
        return empMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<Emp> queryEmpList(
            Integer page, Integer limit, String name, String mobile,
            Integer gender, String depName
    ) {
        PageHelper.startPage(page, limit);
        List<Emp> empList = empMapper.selectEmpList(name, mobile, gender, depName);
        PageInfo<Emp> info = new PageInfo<>(empList);
        return new PageResult<>(info.getTotal(), empList);
    }
}
