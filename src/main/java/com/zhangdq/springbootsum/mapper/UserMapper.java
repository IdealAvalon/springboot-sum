package com.zhangdq.springbootsum.mapper;

import com.zhangdq.springbootsum.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 20:58 2018/6/10
 */
public interface UserMapper {

    /**
     * 根据用户名密码查找用户
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from user where username=#{username} and password =#{password}")
    public User getUserByUsernameAndPassword(User user);
}
