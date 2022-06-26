package org.kuro.erp.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.exceptions.BusinessException;
import org.kuro.erp.mapper.DepMapper;
import org.kuro.erp.model.bo.DepBo;
import org.kuro.erp.model.entity.Dep;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.result.ResultCode;
import org.kuro.erp.model.vo.DepVo;
import org.kuro.erp.service.DepService;
import org.kuro.erp.service.EmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepMapper depMapper;

    @Autowired
    private EmpService empService;

    @Override
    public PageResult<DepVo> depList(Integer page, Integer limit, String depName, String tele) {
        PageHelper.startPage(page, limit);
        List<Dep> deps = depMapper.selectDepList(tele, depName);
        PageInfo<Dep> info = new PageInfo<>(deps);

        List<DepVo> list = new ArrayList<>();
        deps.forEach(item -> {
            DepVo vo = new DepVo();
            BeanUtils.copyProperties(item, vo);
            Integer count = empService.empDepNum(item.getId());
            vo.setEmpCount(count);
            list.add(vo);
        });

        return new PageResult<>(info.getTotal(), list);
    }


    @Override
    public List<String> allDep() {
        return depMapper.selectAllNormal();
    }


    @Override
    public void save(DepBo bo) {
        Dep dep = new Dep();
        BeanUtils.copyProperties(bo, dep);
        dep.setId(IdUtil.getSnowflakeNextIdStr());

        depMapper.insertSelective(dep);
    }


    @Override
    public void update(DepBo bo) {
        Dep dep = new Dep();
        BeanUtils.copyProperties(bo, dep);
        dep.setUpdateTime(new Date());

        depMapper.updateByPrimaryKeySelective(dep);
    }


    @Override
    public void deleteDep(String id) {
        Integer count = empService.empDepNum(id);
        if (count > 0) {
            throw new BusinessException(ResultCode.DEP_HAS_EMP);
        }
        depMapper.deleteByPrimaryKey(id);
    }
}
