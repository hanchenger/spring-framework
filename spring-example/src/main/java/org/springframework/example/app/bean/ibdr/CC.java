package org.springframework.example.app.bean.ibdr;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;

@Import(E.class)
@Slf4j(topic = "e")
public class CC {
	public CC(){
		log.debug("create cc");
	}

}
