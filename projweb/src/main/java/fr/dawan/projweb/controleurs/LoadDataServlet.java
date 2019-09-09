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
 * Servlet implementation class LoadDataServlet
 */
@WebServlet("/LoadDataServlet")
public class LoadDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for (int i = 0; i < 100; i++) {
			
			
			try {
				Utilisateur u = new Utilisateur();
				u.setNom("Abdul Lebagarreur");
				u.setEmail("abdullebagarreur@gmail.com" + i);
				u.setPassword("labagarre");
				EntityManager em = emf.createEntityManager();
				GenericDao.saveOrUpdate(u, 0, em, true);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
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
