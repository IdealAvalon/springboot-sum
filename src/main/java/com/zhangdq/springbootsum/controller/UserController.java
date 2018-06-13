package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户管理界面，并查询出所有用户
     * @return
     */
    @GetMapping("/users")
    public String toUserManager(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users",allUsers);
        return "user/user_manage";
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @GetMapping("/user")
    public String toUserAdd(){
        return "user/user_add";
    }

    /**
     * 添加用户
     * Method: post
     */
    @PostMapping("/user")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    /**
     * 跳转到修改用户信息页面
     * 这里重用user_add.html页面
     * @return
     */
    @GetMapping("/user/{id}")
    public String toUpdateUser(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/user_add";
    }

    /**
     * 修改用户信息操作
     * @return
     */
    @PutMapping("/user")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

}
