package org.springframework.example.app;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.example.app.bean.*;
import org.springframework.example.app.bean.ibdr.util.X;
import org.springframework.example.app.bean.ibdr.util.Y;


@Configuration
@ComponentScan("org.springframework.example.app.bean.ibdr")
//@Import({D.class,E.class,H.class,K.class})
@Import(X.class)
@Slf4j(topic = "e")
public class App {


//	@Import(C.class)
//	class MemberApp{
//
//		public MemberApp(){
//			log.debug("create MemberApp");
//		}
//	}


}
