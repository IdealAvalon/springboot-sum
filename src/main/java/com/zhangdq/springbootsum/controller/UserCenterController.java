package com.zhangdq.springbootsum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:21 2018/6/18
 */
@Controller
public class UserCenterController {

    /**
     * 跳转到图片发布页面
     * @return
     */
    @RequestMapping("/users/publish")
    public String publish(){
        return "/user-center/publish/home";
    }
}
