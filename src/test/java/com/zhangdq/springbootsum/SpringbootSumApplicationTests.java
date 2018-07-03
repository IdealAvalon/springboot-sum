package com.zhangdq.springbootsum;

import com.zhangdq.springbootsum.mapper.PictureMapper;
import com.zhangdq.springbootsum.pojo.Picture;
import com.zhangdq.springbootsum.pojo.User;
import com.zhangdq.springbootsum.service.TestService;
import com.zhangdq.springbootsum.service.UserService;
import com.zhangdq.springbootsum.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

	@Autowired
	TestService testService;

	@Test
	public void testValue(){
		testService.outUrl();

	}

	/**
	 * 测试读取配置文件信息
	 */
	@Value("${IMAGE_SERVER_URL}")
	private String url;
	@Test
	public void testURL(){
		System.out.println(url);
	}

	/**
	 * 测试图片insert
	 */

	@Autowired
	PictureMapper pictureMapper;
	@Test
	public void testInsertPicture(){
		Picture picture = new Picture();
		picture.setPictureSrc("http://120.78.161.117:8888/group1/M00/00/00/rBL6CFs7K5KAPHXvAABHCC7xdws519.jpg");
		pictureMapper.insertPicture(picture);
	}

	@Test
	public void testGetPictures(){
		List<Picture> pictures = pictureMapper.getPictures();
		for(Picture p:pictures){
			System.out.println(p.getPictureSrc());
		}
	}

}
