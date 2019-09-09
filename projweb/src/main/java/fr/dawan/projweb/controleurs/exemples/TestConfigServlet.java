package fr.dawan.projweb.controleurs.exemples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConfigServlet
 */
@WebServlet(urlPatterns="/TestConfigServlet", 
initParams= {
@WebInitParam(name="prenom", value="Anonymous"),
@WebInitParam(name="nom", value="Not Provided") })
public class TestConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConfigServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(getRequestParameterWithDefaultValue(request, "prenom") + " " 
				+ getRequestParameterWithDefaultValue(request, "nom"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}
	
	// Méthode qui teste si le paramètre reçu est vide, si vide retourne la valeur par défaut via la méthode 
	// getInitParameter()
	private String getRequestParameterWithDefaultValue(HttpServletRequest request, String paramName) {
		
//		if(request.getParameter(paramName).isEmpty()) {
//			return getInitParameter(paramName);
//		} else {
//			return request.getParameter(paramName)
//		}
		
		
		return request.getParameter(paramName).isEmpty()?getInitParameter(paramName):request.getParameter(paramName);
				
	}

}
