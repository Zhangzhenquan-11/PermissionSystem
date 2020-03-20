package com.jxau.ssm.service;

import com.jxau.ssm.model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(Integer id) throws Exception;

    void deleteById(Integer id) throws Exception;
}
