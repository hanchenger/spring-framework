package org.springframework.example.batis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface TMapper {


	@Select("select * from t")
	public List<Map<String,Object>> queryFroList();

	@Select("select * from t where id = ${id}")
	public Map<String,Object> queryFroMap(Integer id );
}
