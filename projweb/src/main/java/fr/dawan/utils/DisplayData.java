package fr.dawan.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import fr.dawan.projweb.dao.GenericDao;
import fr.dawan.projweb.entites.Utilisateur;

public class DisplayData {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	public static <T> HttpServletRequest display(String className, HttpServletRequest request) throws Exception {

		List<T> users = null;
		EntityManager em = emf.createEntityManager();
		boolean error = false;
		String msg = null;
		
		try {
			users = GenericDao.findAll(className, em, true);
			request.setAttribute("users", users);
		} catch (Exception e) {
			error = true;
			msg = "Les champs ne doivent pas être vide";
			request.setAttribute("error", error);
			request.setAttribute("msgError", msg);
//			request.getRequestDispatcher("index.jsp");
		}
		return request;
	}
	
	
}
