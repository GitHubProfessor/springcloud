package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;

/**
 * 使用了Feign以后，controller将不再使用restTemplate模板来调用rest接口了。
 * 而是直接使用api中定义的接口，来直接面向接口的方式调用服务提供者提供的restful服务
 * ribbon 和 feign的对比分别看dept-80和dept-feign两个工程就行
 * 
 * @author liuhb
 *
 */
@RestController
public class DeptController_Consummer {
	@Autowired
	private DeptClientService service;//api工程中，service包中定义的Feign相关的接口
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return this.service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(Dept dept){
		//return restTemplate.getForObject(REST_URL_PERFIX + "/dept/list", List.class);
		
		//我们发现，使用Feign后，不再使用restTempate了，而是直接使用面向接口的方式，通过调用接口来调用服务。而服务具体的内容，就在api工程中的service包下的feign相关的接口中。
		return this.service.list();
	}
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return this.service.add(dept);
		
	}
}
