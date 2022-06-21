package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.DepMapper;
import org.kuro.erp.model.entity.Dep;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepMapper depMapper;

    @Override
    public PageResult<Dep> depList(Integer page, Integer limit, String depName, String tele) {
        PageHelper.startPage(page, limit);
        List<Dep> deps = depMapper.selectDepList(tele, depName);
        PageInfo<Dep> info = new PageInfo<>(deps);
        return new PageResult<>(info.getTotal(), deps);
    }


    @Override
    public List<Dep> allDep() {
        return depMapper.selectAllNormal();
    }
}
