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

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		String nom = request.getParameter("nom");
		String msgSuccess = "";
		boolean error = false;
		String msg = null;
		
		if(email != null && !email.trim().isEmpty() 
			&& pwd != null && !pwd.trim().isEmpty()
			&& nom != null && !nom.trim().isEmpty()){
				Utilisateur u = new Utilisateur();
				u.setNom(nom);
				u.setEmail(email);
				u.setPassword(pwd);
				EntityManager em = emf.createEntityManager();
				try {
					GenericDao.saveOrUpdate(u, 0, em, true);
					msgSuccess = "Votre compte utilisateur a bien été créé";
					request.setAttribute("msgSuccess", msgSuccess);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} catch (Exception e) {
					error = true;
					msg = e.getMessage();
					request.setAttribute("error", error);
					request.setAttribute("msgError", msg);
					request.getRequestDispatcher("authentification.jsp").forward(request, response);
				
				}
			}else {
				error = true;
				msg = "Veuillez remplir les champs obligatoire";
				request.setAttribute("error", error);
				request.setAttribute("msgError", msg);
				doGet(request, response);
				
				request.getRequestDispatcher("authentification.jsp").forward(request, response);
			}
		
	}

}
