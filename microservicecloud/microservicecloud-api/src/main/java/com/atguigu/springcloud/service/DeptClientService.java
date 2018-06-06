package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springcloud.entity.Dept;

/**
 * feign就是接口+注解来实现负载均衡，是一种面向接口的思想
 * 用feign时，就要这么写。不用feign就不用这么写了
 *
 *@FeignClient(value="MICROSERVICECLOUD-DEPT")
 *当使用Hystrix时，换乘下面的注解。不适用Hystrix时，用这个注解
 */
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)//此controller中所有的方法出现异常时，都去找fallbackFactory对应的这个类中的方法处理
public interface DeptClientService {
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list();
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept);
}
