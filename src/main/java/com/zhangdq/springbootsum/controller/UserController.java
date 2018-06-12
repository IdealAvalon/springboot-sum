package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 跳转到用户管理界面，并查询出所有用户
     * @return
     */
    @GetMapping("/user")
    public String toUserManager(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users",allUsers);
        return "user/user_manage";
    }
}
