package fr.dawan.teegraph.controleurs;

import java.io.IOException;
import javax.servlet.ServletException;
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
		// TODO Auto-generated method stub
		System.out.println("Testing de MyFirstServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}























//package fr.dawan.projweb.controleurs;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class MyFirstServlet
// */
//@WebServlet("/MyFirstServlet")
//public class MyFirstServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MyFirstServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Coucou je suis bien dans MyFirstServlet");
//
//		// VÃ©rification des paramÃ¨tres d'entrÃ©e
//		if(request.getParameter("prenom") != null && !request.getParameter("prenom").trim().isEmpty() 
//			&& request.getParameter("nom") != null && !request.getParameter("nom").trim().isEmpty()) {
//			
//			response.setContentType("text/html");
//			
//			// RÃ©cupÃ©ration des paramÃ¨tres reÃ§u dans l'objet request
//			// Toujours rÃ©cupÃ©rÃ© sous forme de String
//			String prenom = request.getParameter("prenom");
//			String nom = request.getParameter("nom");
//			
//			PrintWriter out = response.getWriter();
//			out.print("<HEAD><TITLE>");
//			out.print("Java EE Servlet/JSP");
//			out.print("</TITLE></HEAD><BODY>");
//			out.print("<h1>Voici la rÃ©ponse envoyÃ©e par ma premiÃ¨re servlet!");
//			out.print("</h1><p>Bonjour " + prenom + " " + nom);
//			out.print("</p></BODY>");
//			out.close();
//		}
//		else {
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.print("<HEAD><TITLE>");
//			out.print("Java EE Servlet/JSP");
//			out.print("</TITLE></HEAD><BODY>");
//			out.print("<h1>Voici la rÃ©ponse envoyÃ©e par ma premiÃ¨re servlet!");
//			out.print("</h1><p>Bonjour ");
//			out.print("</p></BODY>");
//			out.close();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}
//	
//	@Override
//	// MÃ©thode appelÃ©e lors de l'arrÃªt du serveur ou lors de la destruction de la servlet
//	public void destroy() {
//		System.out.println("Destruction de la servlet...");
//		super.destroy();
//	}
//	
//	@Override
//	// MÃ©thode appelÃ©e avant les mÃ©thodes doGet() et doPost()
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("Je suis dans la mÃ©thode service");
//		super.service(req, res);
//	}
//	
//	@Override
//	// MÃ©thode appelÃ©e avant la mÃ©thode service()
//	public void init() throws ServletException {
//		System.out.println("Je suis dans la mÃ©thode init");
//		super.init();
//	}
//}
//
//
//
