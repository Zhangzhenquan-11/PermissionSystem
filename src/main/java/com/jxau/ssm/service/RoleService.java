package com.jxau.ssm.service;


import com.jxau.ssm.model.Permission;
import com.jxau.ssm.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(Integer roleId) throws Exception;

    void deleteRoleById(Integer roleId) throws Exception;

    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception;
}
