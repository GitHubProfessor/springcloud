package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entity.Dept;

import feign.hystrix.FallbackFactory;

/**
 * Hystrix服务降级使用，
 * 同时，将microservicecloud-provider-dept-hystrix-8001的controller中的@HystrixCommand注解放到这里，实现解耦
 * 根据名字FallbackFactory就可看出，此类专门用于处理Hystrix的fallbackMethod的
 */
@Component  //千万不要忘了加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable throwable) {
		return new DeptClientService() {
			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID:"+ id + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭").setDb_source("no this database in MySQL");
			}
			
			/**
			 * 此方法对应于DeptClientService中的方法，此处因为实验室，就不写代买了。参考get方法就行
			 */
			@Override
			public List<Dept> list() {
				return null;
			}
			
			/**
			 * 此方法对应于DeptClientService中的方法，此处因为实验室，就不写代买了。参考get方法就行
			 */
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
