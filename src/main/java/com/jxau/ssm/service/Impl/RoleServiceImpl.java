package com.jxau.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.RoleDao;
import com.jxau.ssm.model.Permission;
import com.jxau.ssm.model.Role;
import com.jxau.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(Integer roleId) throws Exception {
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception {
        for (Integer permissionId:permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
