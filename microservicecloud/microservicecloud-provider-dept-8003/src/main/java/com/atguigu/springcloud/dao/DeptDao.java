package com.atguigu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entity.Dept;

@Mapper //spring boot mybatis整合，必须要使用
public interface DeptDao {

	public Boolean addDept(Dept dept);
	
	public Dept findById(Long id);
	
	public List<Dept> findAll();
}
