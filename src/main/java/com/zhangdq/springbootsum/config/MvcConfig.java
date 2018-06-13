package com.zhangdq.springbootsum.config;

import com.zhangdq.springbootsum.component.UserAutoLoginInterceptor;
import com.zhangdq.springbootsum.utils.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

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
        registry.addViewController("/userHome").setViewName("user/user_home");
    }

    /**
     * 日期类型转换器
     */
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct //spring容器初始化的时候执行该方法
    public void initEditableValidation(){
        ConfigurableWebBindingInitializer initializer=(ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService()!=null){
            GenericConversionService genericConversionService=(GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }

    /**
     * 自定义自动登录拦截器，用于测试
     * @return
     */
    @Bean
    public UserAutoLoginInterceptor userAutoLoginInterceptor(){
        return new UserAutoLoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAutoLoginInterceptor()).addPathPatterns("/**");
    }
}
