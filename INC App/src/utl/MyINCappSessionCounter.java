package utl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyINCappSessionCounter implements HttpSessionListener{
	static final Logger logger = LogManager.getLogger();
	static private int activeSessions;
	public static int getActiveSessions(){
		return activeSessions;
	}
	public void sessionCreated(HttpSessionEvent event){
		activeSessions++;
		logger.info("Session created, Total active Sessions"+activeSessions);
	}
	public void sessionDestroyed(HttpSessionEvent event) {
		activeSessions--;
		logger.info("Session destroyed, Total active Sessions"+activeSessions);
	}
	
}
