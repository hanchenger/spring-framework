package org.springframework.example.visitor.util;

public class AnnotationMetaDataInfo {

	//注解类型
	Class annotationType;
	//源
	String annotationSource;
	//注解的名字
	String annotationName;


	public Class getAnnotationType() {
		return annotationType;
	}

	public void setAnnotationType(Class annotationType) {
		this.annotationType = annotationType;
	}

	public String getAnnotationSource() {
		return annotationSource;
	}

	public void setAnnotationSource(String annotationSource) {
		this.annotationSource = annotationSource;
	}

	public String getAnnotationName() {
		return annotationName;
	}

	public void setAnnotationName(String annotationName) {
		this.annotationName = annotationName;
	}
}
