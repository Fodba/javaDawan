package fr.dawan.projweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.dawan.projweb.entites.Qcm;
import fr.dawan.projweb.entites.Question;
import fr.dawan.projweb.entites.Reponse;
import fr.dawan.projweb.entites.Utilisateur;
import junit.framework.TestCase;

public class UtilisateurDaoTest extends TestCase {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

	@Test
	public void testFindByEmail() {
		try {
			EntityManager em = emf.createEntityManager();
			
			Utilisateur u1 = new Utilisateur();
			u1.setNom("Mohamed");
			u1.setEmail("mderkaoui@dawan.fr");
			GenericDao.saveOrUpdate(u1, u1.getId(), em, false);
			System.out.println("user 1 inséré !");
			
			Utilisateur u = UtilisateurDao.findByEmail("mderkaoui@dawan.fr", em, true);
			assertEquals("Mohamed", u.getNom());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	
	
}
