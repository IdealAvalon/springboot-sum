package com.zhangdq.springbootsum.service;

import com.zhangdq.springbootsum.mapper.UserMapper;
import com.zhangdq.springbootsum.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 通过ID查询用户
     */
    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }
    /**
     * 通过用户名密码查询用户
     * @param user
     * @return
     */
    public User getUserByUsernameAndPassword(User user) {
        User user2 = userMapper.getUserByUsernameAndPassword(user);
        logger.debug(user.getUsername() + " login");
        return user2;
    }

    public List<User> getAllUsers(){
        return userMapper.getAll();
    }

    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {

        return userMapper.updateUser(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
