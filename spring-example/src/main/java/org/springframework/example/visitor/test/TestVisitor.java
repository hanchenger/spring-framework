package org.springframework.example.visitor.test;

import org.springframework.asm.ClassReader;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.example.visitor.util.MetaDataInfo;
import org.springframework.example.visitor.util.MyClassVisitor;

import java.io.IOException;

public class TestVisitor {

	private static final  int PARSING_OPTIONS = ClassReader.SKIP_DEBUG | ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES;

	public static void main(String[] args) {
		MyClassVisitor myClassVisitor = new MyClassVisitor(SpringAsmInfo.ASM_VERSION);
		try {
			ClassReader classReader = new ClassReader("org.springframework.example.visitor.bean.A");
			classReader.accept(myClassVisitor,PARSING_OPTIONS);
		} catch (IOException e) {
			e.printStackTrace();
		}

		MetaDataInfo metadataInfo = myClassVisitor.getMetadataInfo();
		System.out.println(metadataInfo);
	}
}
