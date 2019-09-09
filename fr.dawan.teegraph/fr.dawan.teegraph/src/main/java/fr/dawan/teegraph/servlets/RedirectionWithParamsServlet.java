package fr.dawan.teegraph.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectionWithParamsServlet
 */
@WebServlet("/RedirectionWithParamsServlet")
public class RedirectionWithParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectionWithParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("login").trim().isEmpty() || request.getParameter("password").trim().isEmpty()) {
			
			request.setAttribute("msgError", "Renseigner les champs avant de vous connecter");
			request.getRequestDispatcher("/exemples.jsp").forward(request, response);
			
		} else if(request.getParameter("login").trim().equals("Arnaud") && request.getParameter("password").trim().equals("Arnaud123")) {
			
			request.setAttribute("name", request.getParameter("login"));
			request.getRequestDispatcher("WEB-INF/redirectionDynamiqueExemple.jsp").forward(request, response);
			
		} else {
			
			request.setAttribute("msgError", "Couple login/mot de passe erroné");
			request.getRequestDispatcher("/exemples.jsp").forward(request, response);
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
