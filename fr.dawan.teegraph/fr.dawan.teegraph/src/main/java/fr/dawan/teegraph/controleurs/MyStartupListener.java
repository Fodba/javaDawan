package fr.dawan.teegraph.controleurs;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyStartupListener
 *
 */
@WebListener
public class MyStartupListener implements ServletContextListener {

	private static EntityManagerFactory emf;
	
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         emf = Persistence.createEntityManagerFactory(
        		 				"mypersistence-unit");
    }
    
    
    public static EntityManagerFactory getEmf() {
		return emf;
	}


	/**
     * Default constructor. 
     */
    public MyStartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
	
}
