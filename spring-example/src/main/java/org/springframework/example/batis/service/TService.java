package org.springframework.example.batis.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TService {

	public List<Map<String,Object>> queryFroList();

	public Map<String,Object> queryFroMap(Integer id );
}
