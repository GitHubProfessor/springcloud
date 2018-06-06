package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 此消费者主要用于实现监控Hystrix
 * @author liuhb
 *
 */
@SpringBootApplication
@EnableHystrixDashboard  //用于启动Hystrix仪表盘，查看监控内容
public class DeptConsummer9001_DashBoard_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsummer9001_DashBoard_App.class, args);
	}

}
