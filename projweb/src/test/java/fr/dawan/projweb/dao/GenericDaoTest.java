package fr.dawan.projweb.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.dawan.projweb.entites.Produit;
import fr.dawan.projweb.entites.Produit.EtatProduit;
import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericDaoTest extends TestCase {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public static void testSaveOrUpdate() {
		try {
			Produit p = new Produit();
			p.setDescription("Ordi");
			p.setPrix(150F);
			p.setDateAchat(new Date());
			p.setEtat(EtatProduit.TB);
			EntityManager em = emf.createEntityManager();
			GenericDao.saveOrUpdate(p, 0, em, true);
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindById() {
		try {
			EntityManager em = emf.createEntityManager();
			Produit p = GenericDao.findById(Produit.class, 2L, em, true);
			assertEquals("Ordi", p.getDescription());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindAll() {
		//requête pour lister l'ensemble =>listeP
		//requête pour compter le nb de produits
		//vérifier si nb = listeP.size()
		try {
			EntityManager em = emf.createEntityManager();
			List<Produit> lp = GenericDao.findAll("Produit", em, false);
			long nb = GenericDao.countElements("Produit", em, true);
			System.out.println("nb = " + nb);
			
			System.out.println("Liste des produits ___");
			for (Produit p : lp) {
				System.out.println(p.getDescription());
			}
			
			assertEquals(nb, lp.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindPartial() {
		//requête pour récupérer 3 éléments
		//vérifier que 3=listeP.size()
		try {
			EntityManager em = emf.createEntityManager();
			List<Produit> lp = GenericDao.findPartial("Produit", 0, 3, em, true);
			assertEquals(3, lp.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemove() {
		//supprimer l'elt dont l'id = 1
		try {
			EntityManager em = emf.createEntityManager();
			int res = GenericDao.remove("Produit", 1L, em, false);
			assertEquals(1, res);
			//assertEquals(0, res); vu qu'il existe pas
			
			//rechercher le produit avec ud=1 => p
			Produit p = GenericDao.findById(Produit.class, 1L, em, true);
			assertNull(p);
				
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testFindAllWithParams() {
		//les produits dont le prix <300
		try {
			//rechercher le produit avec ud=1 => p
			EntityManager em = emf.createEntityManager();
			String requete = "FROM Produit p WHERE p.prix < :p1";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("p1",300F);
			List<Produit> lp = GenericDao.findAll(requete, parameters, em, true);
			assertNotNull(lp);
			System.out.println("Liste des produits < 300 ___");
			for (Produit p : lp) {
				System.out.println(p.getDescription() + "\t" + p.getPrix());
			}
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	

}
