package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * 如果api中的DeptClientService.java中@FeignClient注解没使用fallbackFactory属性，那么就启动这个工程
 * 否则就启动microservicecloud-provider-dept-8001工程
 * 原因：
 *      @FeignClient中带有fallbackFactory属性，说明通过此接口的方式，来使用hystrix进行服务熔断和降级。这样可以达到与业务解耦。
 *      但如果@FeignClient中没使用，那么就需要在跟次controller一样，每个方法都对应一个处理熔断和降级的的方法。
 *      两个工程同事存在，只是为了对比不同之处。所以不要同时都启动。这就如同消费者dept-80和dept-feign一样。都是为了说明不同之处，但是不能同时启动
 * @author liuhb
 *
 */
@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get") //一旦调用服务方法失败并抛出了错误信息后，会自动调用processHystrix_Get方法
	public Dept get(@PathVariable("id") Long id){
		Dept dept = service.get(id);
		if(null == dept){
			throw new RuntimeException("该ID:" + id + "没有对应的信息");
		}
		
		return dept;
	}
	
	//上面@HystrixCommand注解中fallbackMethod指定的方法。用来给controller方法擦屁股的方法
	public Dept processHystrix_Get(@PathVariable("id") Long id){
		return new Dept().setDeptno(id).setDname("该ID:"+ id + "没有对应的信息，null--@HystrixCommand").setDb_source("no this database in MySQL");
	}
}
