package fr.dawan.projweb.controleurs;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import fr.dawan.projweb.entites.Produit;
import fr.dawan.projweb.entites.Produit.EtatProduit;
import fr.dawan.utils.DisplayData;

/**
 * Servlet implementation class GestionProduitsServlet
 */
@WebServlet("/GestionProduitsServlet")
public class GestionProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionProduitsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		EntityManager em = emf.createEntityManager();
		switch (action) {
		case "insert":
			try {
				Produit p = new Produit();
				p.setDescription("description");
				p.setEtat(EtatProduit.valueOf(request.getParameter("etat")));
				p.setPrix(Float.parseFloat(request.getParameter("prix")));
				p.setDateAchat(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("DAchat")));
				GenericDao.saveOrUpdate(p, 0, em, false);
				DisplayData.display("Produit", request);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			break;
		case "read":
			try {
				DisplayData.display("Produit", request);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		case "update":
			break;
		case "delete":
			break;
		default:
			break;
		}

		int produitCount = (int) GenericDao.countElements("Produit", em, false);
		int indice = Integer.parseInt(request.getParameter("indice"));

		request.setAttribute("produitCount", produitCount);
		request.setAttribute("indice", indice);
		List<Produit> produits = null;
		try {
			produits = GenericDao.findPartial("Produit", (indice - 1) * 10, 10, em, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("users", produits);

		EtatProduit[] etatProduitValues = EtatProduit.values();
		request.setAttribute("etatProduitValues", etatProduitValues);
		request.getRequestDispatcher("Gestion_Produit.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object obj = new Integer(3);
		String str = (String)
		
		
		doGet(request, response);
	}

}
