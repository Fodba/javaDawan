package fr.dawan.teegraph.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyNbVisiteursListener
 *
 */
public class MyNbVisiteursListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyNbVisiteursListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         int nb = 1;
         ServletContext application = se.getSession().getServletContext();
         Object obj = application.getAttribute("nbVisiteurs");
         if(obj!=null) {
        	 nb = ((Integer)obj)+1;
         }
         application.setAttribute("nbVisiteurs", nb);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext application = se.getSession().getServletContext();
        Object obj = application.getAttribute("nbVisiteurs");
        if(obj!=null) {
        	int nb = ((Integer)obj)-1;
        	application.setAttribute("nbVisiteurs", nb);
        }
        
    }
	
}
