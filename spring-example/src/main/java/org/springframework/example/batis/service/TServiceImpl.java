package org.springframework.example.batis.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.example.batis.dao.AMapper;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TServiceImpl implements TService {

	//1、对象？
	//2、tMapper如何产生的？谁产生的
	@Autowired
	TMapper tMapper;
	@Autowired
	AMapper aMapper;

	@Override
	public List<Map<String, Object>> queryFroList() {
		aMapper.queryFroList();
		return tMapper.queryFroList();
	}

	@Override
	public Map<String, Object> queryFroMap(Integer id) {
		return tMapper.queryFroMap(id);
	}
}
