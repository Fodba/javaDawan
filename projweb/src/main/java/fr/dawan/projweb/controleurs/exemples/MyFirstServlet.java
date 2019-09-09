package fr.dawan.projweb.controleurs.exemples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Coucou je suis bien dans MyFirstServlet");

		// Vérification des paramètres d'entrée
		if(request.getParameter("prenom") != null && !request.getParameter("prenom").trim().isEmpty() 
			&& request.getParameter("nom") != null && !request.getParameter("nom").trim().isEmpty()) {
			
			response.setContentType("text/html");
			
			// Récupération des paramètres reçu dans l'objet request
			// Toujours récupéré sous forme de String
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			
			PrintWriter out = response.getWriter();
			out.print("<HEAD><TITLE>");
			out.print("Java EE Servlet/JSP");
			out.print("</TITLE></HEAD><BODY>");
			out.print("<h1>Voici la réponse envoyée par ma première servlet!");
			out.print("</h1><p>Bonjour " + prenom + " " + nom);
			out.print("</p></BODY>");
			out.close();
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<HEAD><TITLE>");
			out.print("Java EE Servlet/JSP");
			out.print("</TITLE></HEAD><BODY>");
			out.print("<h1>Voici la réponse envoyée par ma première servlet!");
			out.print("</h1><p>Bonjour ");
			out.print("</p></BODY>");
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	@Override
	// Méthode appelée lors de l'arrêt du serveur ou lors de la destruction de la servlet
	public void destroy() {
		System.out.println("Destruction de la servlet...");
		super.destroy();
	}
	
	@Override
	// Méthode appelée avant les méthodes doGet() et doPost()
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Je suis dans la méthode service");
		super.service(req, res);
	}
	
	@Override
	// Méthode appelée avant la méthode service()
	public void init() throws ServletException {
		System.out.println("Je suis dans la méthode init");
		super.init();
	}

	
}
