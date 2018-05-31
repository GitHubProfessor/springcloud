package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entity.Dept;

@RestController
public class DeptController_Consummer {

	private static final String REST_URL_PERFIX = "http://localhost:8001";
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PERFIX + "/dept/add", dept, Boolean.class);
		
	}
	
	@RequestMapping(value="/consummer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PERFIX + "/dept/get/"+id,Dept.class);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(Dept dept){
		return restTemplate.getForObject(REST_URL_PERFIX + "/dept/list", List.class);
		
	}
	
	/**
	 * 测试@EnableDisconveryClient，消费者可以调用服务发现
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PERFIX + "/dept/discovery", Object.class);
		
	}
}
