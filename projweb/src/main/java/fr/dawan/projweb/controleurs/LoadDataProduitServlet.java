package fr.dawan.projweb.controleurs;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;

import fr.dawan.projweb.dao.GenericDao;
import fr.dawan.projweb.entites.Produit;
import fr.dawan.projweb.entites.Utilisateur;
import fr.dawan.projweb.entites.Produit.EtatProduit;
import fr.dawan.utils.DisplayData;

/**
 * Servlet implementation class LoadDataProduitServlet
 */
@WebServlet("/LoadDataProduitServlet")
public class LoadDataProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadDataProduitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		List<Produit> listeProduits = null;
//		for (int i = 0; i < 100; i++) {
//
//			try {
//				Produit u = new Produit();
//				u.setDescription("Produit N° " + i);
//				u.setDateAchat(new Date());
//				u.setEtat(EtatProduit.TB);
//				EntityManager em = emf.createEntityManager();
//				GenericDao.saveOrUpdate(u, 0, em, true);
//
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}

		try {
			EntityManager em = emf.createEntityManager();
//			listeProduits = GenericDao.findAll("Produit", em, true);
//			for (int i = 0; i < listeProduits.size(); i++) {
//				System.out.println(listeProduits.get(i).getDescription());
//				System.out.println(listeProduits.get(i).getDateAchat());
//			}
//			request.setAttribute("produits", listeProduits);
			DisplayData.display("Produit", request);
			request.getRequestDispatcher("display.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
