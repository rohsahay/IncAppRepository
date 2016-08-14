package utl;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event){
		//get notified when the context is initialized
		ServletContext sc=event.getServletContext();
		String init=sc.getInitParameter("admin-email");
		System.out.println(init);
		//this is to test listener
	}
	public void contextDestroyed(ServletContextEvent event){
		//get notified when the context is destroyed
		
	}
}