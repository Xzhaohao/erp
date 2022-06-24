package org.kuro.erp.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kuro.erp.mapper.EmpMapper;
import org.kuro.erp.mapper.EmpRoleMapper;
import org.kuro.erp.model.bo.SaveEmpBo;
import org.kuro.erp.model.entity.Emp;
import org.kuro.erp.model.entity.EmpRole;
import org.kuro.erp.model.entity.Role;
import org.kuro.erp.model.page.PageResult;
import org.kuro.erp.model.vo.EmpVo;
import org.kuro.erp.service.EmpService;
import org.kuro.erp.service.RoleService;
import org.kuro.erp.utils.GenerateAvatar;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public Emp queryEmpByMobile(String mobile) {
        return empMapper.selectEmpByMobile(mobile);
    }


    @Override
    public EmpVo queryEmpById(String id) {
        Emp emp = empMapper.selectByPrimaryKey(id);
        return empSetRoles(emp);
    }


    @Override
    public PageResult<EmpVo> queryEmpList(
            Integer page, Integer limit, String name, String mobile,
            Integer gender, String depName
    ) {
        PageHelper.startPage(page, limit);
        List<Emp> empList = empMapper.selectEmpList(name, mobile, gender, depName);
        PageInfo<Emp> info = new PageInfo<>(empList);

        List<EmpVo> vos = new ArrayList<>();
        for (Emp emp : empList) {
            vos.add(empSetRoles(emp));
        }

        return new PageResult<>(info.getTotal(), vos);
    }


    @Override
    public void save(SaveEmpBo bo) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(bo, emp);

        emp.setId(IdUtil.getSnowflakeNextIdStr());
        emp.setCreateTime(new Date());
        emp.setPassword(BCrypt.hashpw(bo.getPassword()));
        emp.setAvatar(GenerateAvatar.getRandomImg());

        // todo 设置角色

        empMapper.insertSelective(emp);
    }


    @Override
    public void update(Emp bo) {
        empMapper.updateByPrimaryKeySelective(bo);
    }


    private EmpVo empSetRoles(Emp emp) {
        EmpVo vo = new EmpVo();
        BeanUtils.copyProperties(emp, vo);

        List<EmpRole> empRoles = empRoleMapper.selectEmpRoleByEmpId(emp.getId());
        List<Role> roles = new ArrayList<>();
        for (EmpRole empRole : empRoles) {
            Role role = roleService.queryById(empRole.getRoleId());
            roles.add(role);
        }
        vo.setRoles(roles);

        return vo;
    }
}
