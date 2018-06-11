package com.zhangdq.springbootsum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:40 2018/6/10
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    //设置视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/userLogin").setViewName("user_login");
    }
}
