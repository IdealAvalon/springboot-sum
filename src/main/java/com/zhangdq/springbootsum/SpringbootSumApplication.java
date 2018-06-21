package com.zhangdq.springbootsum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = "com.zhangdq.springbootsum.mapper")
@SpringBootApplication
public class SpringbootSumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSumApplication.class, args);
	}
}
