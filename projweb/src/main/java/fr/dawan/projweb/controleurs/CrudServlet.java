package fr.dawan.projweb.controleurs;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.projweb.dao.GenericDao;
import fr.dawan.projweb.entites.Utilisateur;
import fr.dawan.utils.DisplayData;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/CrudServlet")
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		String param = request.getParameter("action");
		String msg = "";
		Utilisateur u = null;
		long id = 0;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			u = GenericDao.findById(Utilisateur.class, id, em, false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			System.out.println(e1.getStackTrace());
			e1.printStackTrace();
		}
		
		System.out.println(id);

		switch (param) {
		case "update":
			try {
				request.setAttribute("user", u);
				DisplayData.display("Utilisateur", request);
				request.getRequestDispatcher("authentification.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				e.printStackTrace();
			}
			break;
		case "updateDone":
			try {
				//Utilisateur u = GenericDao.findById(Utilisateur.class, id, em, true);
				u.setNom(request.getParameter("updateNom"));
				u.setEmail(request.getParameter("updateMail"));
				u.setPassword(request.getParameter("updatePwd"));
				GenericDao.saveOrUpdate(u, id, em, true);
				DisplayData.display("Utilisateur", request);
				request.getRequestDispatcher("authentification.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				e.printStackTrace();
			}
			break;

		case "delete":
			try {
                int result = GenericDao.remove("Utilisateur",Long.parseLong(request.getParameter("id")), em, false);

                if(result == 1) {
                    msg = "Suppression réussie !";
                    DisplayData.display("Utilisateur", request);
                    request.getRequestDispatcher("authentification.jsp").forward(request, response);
                    
                } else {
                    msg = "Echec de la suppression !";
                }
                request.setAttribute("msg", msg);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
