package org.kuro.erp.service.impl;

import org.kuro.erp.mapper.RoleMapper;
import org.kuro.erp.model.entity.Role;
import org.kuro.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> allRoleList() {
        return roleMapper.selectAll();
    }


    @Override
    public Role queryById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
