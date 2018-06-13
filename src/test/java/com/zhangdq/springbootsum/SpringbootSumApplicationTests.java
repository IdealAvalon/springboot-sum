package com.zhangdq.springbootsum;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSumApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	UserService userService;

	@Test
	public void testGetUserById(){
		User user = userService.getUserById(1);
		System.out.println(user.getUsername());
	}
}
