package com.jxau.ssm.service;

import com.jxau.ssm.model.Role;
import com.jxau.ssm.model.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll(Integer page, Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer userId) throws Exception;

    void addRoleToUser(Integer userId, Integer[] roleIds) throws Exception;
}
