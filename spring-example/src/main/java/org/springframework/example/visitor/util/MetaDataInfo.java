package org.springframework.example.visitor.util;

import org.springframework.example.scan.inherited.S;

import java.util.ArrayList;
import java.util.List;

public class MetaDataInfo {

	List<AnnotationMetaDataInfo> list = new ArrayList<>();

	String clazzFullName;


	public List<AnnotationMetaDataInfo> getList() {
		return list;
	}

	public void setList(List<AnnotationMetaDataInfo> list) {
		this.list = list;
	}

	public String getClazzFullName() {
		return clazzFullName;
	}

	public void setClazzFullName(String clazzFullName) {
		this.clazzFullName = clazzFullName;
	}


}
