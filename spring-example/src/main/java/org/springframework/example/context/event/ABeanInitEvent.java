package org.springframework.example.context.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;


/**
 * 这个bean正在被spring容器初始化
 * 这个事件对象不需要在spring容器当中，
 */
public class ABeanInitEvent extends ApplicationContextEvent {

	/**
	 * Create a new ContextStartedEvent.
	 *
	 * @param source the {@code ApplicationContext} that the event is raised for
	 *               (must not be {@code null})
	 */
	public ABeanInitEvent(ApplicationContext source) {
		super(source);
	}
}
