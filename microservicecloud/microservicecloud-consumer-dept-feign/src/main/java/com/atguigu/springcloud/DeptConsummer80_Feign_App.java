package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //add for Ribbon,使用Feign是也需要此注解
@EnableFeignClients(basePackages={"com.atguigu.springcloud"}) //for Feign
@ComponentScan("com.atguigu.springcloud") //for Feign
public class DeptConsummer80_Feign_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsummer80_Feign_App.class, args);
	}

}
