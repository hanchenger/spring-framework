package org.springframework.example.context.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.example.context.event.ABeanInitEvent;
import org.springframework.stereotype.Component;


/**
 * 这个监听对象需要在spring容器当中,因为你要监听的spring的事件，
 */
@Slf4j(topic = "e")
@Component
public class ABeanListener implements ApplicationListener<ABeanInitEvent> {
	@Override
	public void onApplicationEvent(ABeanInitEvent event) {
		log.debug("event:[{}]",event.getClass().getSimpleName());
	}
}
