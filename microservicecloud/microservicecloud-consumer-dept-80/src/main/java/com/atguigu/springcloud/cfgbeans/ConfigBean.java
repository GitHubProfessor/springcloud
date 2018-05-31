package com.atguigu.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { // 等同于 spring的application.xml
	@Bean
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