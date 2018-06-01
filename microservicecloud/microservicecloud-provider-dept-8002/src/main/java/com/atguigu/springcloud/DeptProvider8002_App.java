package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //使用此注解后，本服务启动后，会自动注册到eureka服务中
@EnableDiscoveryClient //服务发现注解。使用注解后，可以自动发现服务，并将发现的所有服务放到DiscoveryClient这个类中，参照DeptController。然后就进可以直接使用DiscoveryClient来获取到所有自动发现的服务内容了
public class DeptProvider8002_App {
	public static void main(String [] args){
		SpringApplication.run(DeptProvider8002_App.class, args);
	}
}
