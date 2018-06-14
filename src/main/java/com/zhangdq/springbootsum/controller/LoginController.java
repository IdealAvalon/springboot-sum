package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 21:22 2018/6/10
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String userLogin(User user, Model model, HttpSession session){
        User queryUser = userService.getUserByUsernameAndPassword(user);
        String msg;
        if(queryUser!=null&&user!=null&&queryUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user",queryUser);
            session.setAttribute("user",queryUser);
            return "redirect:/manage";
        }
        msg="登录失败~";
        model.addAttribute("msg", msg);
        return "user_login";
    }
}
