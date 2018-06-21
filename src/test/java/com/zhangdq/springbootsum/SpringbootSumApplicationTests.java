package com.zhangdq.springbootsum;

import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.UserService;
import com.zhangdq.springbootsum.utils.FastDFSClient;
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

	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("fdfs_client.conf");
		String file = fastDFSClient.uploadFile("/Users/apple/Pictures/动漫壁纸/timg-6.jpeg");
		System.out.println(file);
	}

}
