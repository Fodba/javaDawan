package fr.dawan.projweb.controleurs;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.projweb.dao.GenericDao;
import fr.dawan.projweb.dao.UtilisateurDao;
import fr.dawan.projweb.entites.Utilisateur;
import fr.dawan.utils.DisplayData;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			DisplayData.display("Utilisateur", request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// request.getRequestDispatcher("authentification.jsp");
		request.getRequestDispatcher("authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		String msg = null;
		String msgSuccess = "";
		boolean error = false;

		if (pwd != null && email != null) {
			if (pwd.isEmpty() || email.isEmpty()) {
				error = true;
				msg = "Les champs ne doivent pas être vide";
				request.setAttribute("error", error);
				request.setAttribute("msgError", msg);
			} else {
				EntityManager em = emf.createEntityManager();
				Utilisateur u = UtilisateurDao.findByEmail(email, em, true);

				if (u != null) {
					if (pwd.equals(u.getPassword())) {
						msgSuccess = "Vous êtes maintenant connecté";
						request.setAttribute("msgSuccess", msgSuccess);
						request.getRequestDispatcher("index.jsp").forward(request, response);

					} else {
						error = true;
						msg = "L'email ou le mot de passe est incorrect";
						request.setAttribute("error", error);
						request.setAttribute("msgError", msg);
					}
				} else {
					error = true;
					msg = "L'utilisateur n'existe pas ";
					request.setAttribute("error", error);
					request.setAttribute("msgError", msg);
				}

			}
		}
		doGet(request, response);
		request.getRequestDispatcher("authentification.jsp").forward(request, response);

	}

}
