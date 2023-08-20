package org.springframework.example.batis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AMapper {

	@Select("select * from a")
	public List<Map<String,Object>> queryFroList();

	@Select("select * from a where id = ${id}")
	public Map<String,Object> queryFroMap(Integer id );
}
