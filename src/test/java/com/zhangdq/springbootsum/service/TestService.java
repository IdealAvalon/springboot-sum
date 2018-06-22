package com.zhangdq.springbootsum.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 11:06 2018/6/22
 */
@Service
public class TestService {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    public void outUrl(){
        System.out.println(IMAGE_SERVER_URL);
    }
}
