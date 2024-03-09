package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context Initialized...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context Destroyed...");
	}
}
