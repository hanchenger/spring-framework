package org.springframework.example.batis.mybatis;

import org.springframework.example.batis.dao.AMapper;

import java.util.List;
import java.util.Map;

public class AMapperImpl implements AMapper {
	@Override
	public List<Map<String, Object>> queryFroList() {
		return null;
	}

	@Override
	public Map<String, Object> queryFroMap(Integer id) {
		return null;
	}
}
