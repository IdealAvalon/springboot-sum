package com.zhangdq.springbootsum.mapper;

import com.zhangdq.springbootsum.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 20:58 2018/6/10
 */
public interface UserMapper {

    /**
     * 根据用户id查找用户
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from user where username=#{username} and password =#{password}")
    public User getUserByUsernameAndPassword(User user);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> getAll();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(username,password,gender,email,birth,phone) values(#{username},#{password},#{gender},#{email},#{birth},#{phone})")
    public int insertUser(User user);

    @Update("UPDATE user SET username = #{username},password=#{password},gender=#{gender},email=#{email},birth=#{birth},phone=#{phone} WHERE id = #{id}")
    public int updateUser(User user);
}
