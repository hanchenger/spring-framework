package org.springframework.example.visitor.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.Opcodes;
import org.springframework.asm.Type;
import org.springframework.util.ClassUtils;

import java.util.List;

@Slf4j(topic = "e")
public class MyAnnotationClassVisitor extends AnnotationVisitor {


	public MyAnnotationClassVisitor(String descriptor, List<AnnotationMetaDataInfo> list, String sourceName) throws ClassNotFoundException {
		super(Opcodes.ASM7);
		String className = Type.getType(descriptor).getClassName();
		Class<?> aClass = ClassUtils.forName(className, MyAnnotationClassVisitor.class.getClassLoader());
		AnnotationMetaDataInfo info = new AnnotationMetaDataInfo();
		info.setAnnotationType(aClass);
		info.setAnnotationName(aClass.getSimpleName());
		info.setAnnotationSource(sourceName);
		list.add(info);
	}
}
