package com.jxau.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jxau.ssm.model.Role;
import com.jxau.ssm.model.UserInfo;
import com.jxau.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")Integer size)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)Integer userId,
                              @RequestParam(name = "ids",required = true)Integer[] roleIds)
            throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)Integer userId)
            throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }
}
