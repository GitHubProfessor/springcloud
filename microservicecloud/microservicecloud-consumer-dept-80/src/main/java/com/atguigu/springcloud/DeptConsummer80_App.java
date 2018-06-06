package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //add for Ribbon
public class DeptConsummer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsummer80_App.class, args);
	}
}
