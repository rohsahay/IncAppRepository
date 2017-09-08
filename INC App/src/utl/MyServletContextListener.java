package utl;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyServletContextListener implements ServletContextListener{
	static final Logger logger = LogManager.getLogger();
	public void contextInitialized(ServletContextEvent event){
		//get notified when the context is initialized
		ServletContext sc=event.getServletContext();
		String init=sc.getInitParameter("admin-email");
		logger.info(init);
		//this is to test listener
	}
	public void contextDestroyed(ServletContextEvent event){
		//get notified when the context is destroyed
		
	}
}