package org.springframework.example.batis.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.example.batis.dao.AMapper;
import org.springframework.example.batis.dao.TMapper;

import java.util.List;
import java.util.Map;

public class TMapperImpl implements TMapper {
	@Override
	public List<Map<String, Object>> queryFroList() {
		return null;
	}

	@Override
	public Map<String, Object> queryFroMap(Integer id) {
		return null;
	}
}
