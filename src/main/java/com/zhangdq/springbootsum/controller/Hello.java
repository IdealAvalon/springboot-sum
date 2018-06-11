package com.zhangdq.springbootsum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 19:59 2018/6/8
 */
@RestController
public class Hello {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
