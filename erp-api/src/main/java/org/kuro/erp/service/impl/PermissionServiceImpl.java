package org.kuro.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.PermissionMapper;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.vo.PermissionVo;
import org.kuro.erp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public PageResult<PermissionVo> permissionList(Integer page, Integer limit) {
        if (page != null && limit != null) {
            PageHelper.startPage(page, limit);
        }
        List<PermissionVo> list = permissionMapper.selectPermissionList();
        PageInfo<PermissionVo> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }
}
