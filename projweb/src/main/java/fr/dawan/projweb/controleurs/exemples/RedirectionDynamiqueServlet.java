package fr.dawan.projweb.controleurs.exemples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectionDynamiqueServlet
 */
@WebServlet("/RedirectionDynamiqueServlet")
public class RedirectionDynamiqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectionDynamiqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("login") == null || request.getParameter("login").trim().isEmpty()
				|| request.getParameter("password") == null || request.getParameter("password").trim().isEmpty()) {
			request.setAttribute("msgError", "Renseigner les champs obligatoires");
			request.getRequestDispatcher("exemples.jsp").forward(request, response);
		} else if(request.getParameter("login").equals("Arnaud") && request.getParameter("password").equals("azerty")) {
			
			// Pour injecter dans les ${variable} au niveau dezs pages jsp
			request.setAttribute("name", request.getParameter("login"));
			// Pour rediriger vers une page dynamique 
			request.getRequestDispatcher("WEB-INF/exempleRedirectionDynamique.jsp").forward(request, response);
		} else {
			
			request.setAttribute("msgError", "Couple login/mot de passe incorrect");
			request.getRequestDispatcher("exemples.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
