package fr.dawan.teegraph.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.teegraph.controleurs.MyStartupListener;
import fr.dawan.teegraph.dao.UtilisateurDao;
import fr.dawan.teegraph.entites.Utilisateur;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/authentication")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = MyStartupListener.getEmf().createEntityManager();
		
		if(request.getParameter("email") == null || request.getParameter("email").trim().isEmpty() || request.getParameter("password").trim().isEmpty()) {

			request.setAttribute("msgErrorAuthentification", "Renseigner les champs avant de vous connecter");
			request.getRequestDispatcher("/authentication.jsp").forward(request, response);

		} else {
			
			
			try {
				Utilisateur utilisateur = UtilisateurDao.findByEmail(request.getParameter("email").trim(), em, false);

				
				if(utilisateur != null && request.getParameter("password").trim().equals(utilisateur.getPassword())) {
					
					Cookie cookieEmail = new Cookie("cookieEmail", utilisateur.getEmail());
					Cookie cookiePassword = new Cookie("cookiePassword", utilisateur.getPassword());
					cookieEmail.setMaxAge(600);
					cookiePassword.setMaxAge(600);
					response.addCookie(cookieEmail);
					response.addCookie(cookiePassword);

					request.setAttribute("nameUser", utilisateur.getNom());
					
					request.getSession().setAttribute("userID", utilisateur.getId());
					
					String paramRequest = "?nom=" + utilisateur.getNom();
					
					request.getRequestDispatcher("WEB-INF/session/accueil.jsp" + paramRequest).forward(request, response);

				} else {

					request.setAttribute("msgErrorAuthentification", "Couple email/mot de passe erroné");
					request.getRequestDispatcher("/authentication.jsp").forward(request, response);
				}
			
			} catch (Exception e) {
				request.setAttribute("msgErrorAuthentification", "Erreur de connexion avec la BDD");
				System.out.println(e.getMessage());
				request.getRequestDispatcher("/authentication.jsp").forward(request, response);
			} 
			
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
