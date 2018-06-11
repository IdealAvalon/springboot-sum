package com.zhangdq.springbootsum.service;

import com.zhangdq.springbootsum.mapper.UserMapper;
import com.zhangdq.springbootsum.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 21:08 2018/6/10
 */
@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserByUsernameAndPassword(User user) {
        User user2 = userMapper.getUserByUsernameAndPassword(user);
        logger.debug(user.getUsername() + " login");
        return user2;
    }

}
