package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 用户登录
     * @param user
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/user/login")
    public String userLogin(User user, Model model, HttpSession session){
        User queryUser = userService.getUserByUsernameAndPassword(user);
        String msg;
        if(queryUser!=null&&user!=null&&queryUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user",queryUser);
            session.setAttribute("user",queryUser);
            return "redirect:/index";
        }
        msg="登录失败~";
        model.addAttribute("msg", msg);
        return "sign_in";
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @RequestMapping("/user/logout")
    public String userLogout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/sign";
    }
}
