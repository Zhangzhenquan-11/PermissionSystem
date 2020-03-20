package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.model.Permission;
import com.jxau.ssm.model.Role;
import com.jxau.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")Integer size)
            throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)Integer roleId,
                                      @RequestParam(name = "ids",required = true)Integer[] permissionIds)
            throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "id",required = true)Integer roleId) throws Exception{
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)Integer roleId)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

}
