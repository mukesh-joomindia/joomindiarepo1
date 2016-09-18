package in.xgen.web.listner;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Application Lifecycle Listener implementation class ContextListner
 *
 */
public class ContextListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListner() {
        // TODO Auto-generated constructor stub
    }

	

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    
    	ServletContext context = event.getServletContext();
    	/*String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
        PropertyConfigurator.configure(fullPath);*/
    }



	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		System.out.println("Context Destroyed");
	}



	

    
}
