package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { // 等同于 spring的application.xml
	@Bean
	@LoadBalanced //Ribbon注解，启用负载均衡，实现客户端的负载均衡
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}

/*
 * @Bean
 * publc UserService getUserService(){
 *     return new UserServiceImpl();
 * }
 * application.xml == ConfigBean(@Configuration)
 * <bean id = "userService" class= "com.atguigu.UserServiceImpl">
 */