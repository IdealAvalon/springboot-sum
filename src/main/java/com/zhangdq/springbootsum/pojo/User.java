package com.zhangdq.springbootsum.pojo;

import java.util.Date;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 20:58 2018/6/10
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String email;
    private Date birth;
    private String phone;

    public String getGender() {
        return gender;
    }

    public User(Integer id, String username, String password, String gender, String email, Date birth, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
