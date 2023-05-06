package org.springframework.automode;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.statics.Config;

@Slf4j
public class ModeTest {


	@Test
	public  void dependsOnModel()  {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.dependsOn");
		context.refresh();
	}

	@Test
	public  void staticsModel()  {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
	}
}
