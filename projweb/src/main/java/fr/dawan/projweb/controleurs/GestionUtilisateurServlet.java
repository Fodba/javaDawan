package fr.dawan.projweb.controleurs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.projweb.dao.GenericDao;
import fr.dawan.projweb.entites.Utilisateur;

/**
 * Servlet implementation class GestionUtilisateurServlet
 */
@WebServlet("/session/GestionUtilisateurServlet")
public class GestionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = MyStartupListener.getEmf().createEntityManager();

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		String msg = "";
		// Gestion des différentes actions
		if(request.getParameter("action") != null) {
			
			switch(request.getParameter("action")) {
			case "suppression" :
				try {
					int result = GenericDao.remove("Utilisateur",Long.parseLong(request.getParameter("utilisateurId")), em, false);

					if(result == 1) {
						msg = "Suppression réussie !";
					} else {
						msg = "Echec de la suppression !";
					}
					request.setAttribute("msg", msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "insertion":
				Utilisateur u = new Utilisateur();
				u.setEmail(request.getParameter("email"));
				u.setNom(request.getParameter("nom"));
				u.setPassword(request.getParameter("password"));
				u.setId((request.getParameter("idTest")==null||request.getParameter("idTest").isEmpty())?0:Long.parseLong(request.getParameter("idTest")));

				try {
					GenericDao.saveOrUpdate(u, u.getId(), em, false);
					msg = "Suppression réussie !";

					request.setAttribute("msg", msg);
				} catch (Exception e) {
					request.setAttribute("msg", "Echec de l'insertion");
				}
				break;
			case "modification":
				try {
					Utilisateur user = GenericDao.findById(Utilisateur.class, Long.parseLong(request.getParameter("utilisateurId")), em, false);
					request.setAttribute("userToModify", user);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}
		// partie pour afficher mon tableau
		try {
			utilisateurs = GenericDao.findAll("Utilisateur", em, true);
			request.setAttribute("utilisateurs", utilisateurs);

			request.getRequestDispatcher("/WEB-INF/session/gestion-utilisateurs.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
