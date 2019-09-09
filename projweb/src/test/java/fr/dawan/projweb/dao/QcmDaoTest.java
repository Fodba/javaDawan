package fr.dawan.projweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.dawan.projweb.entites.Qcm;
import fr.dawan.projweb.entites.Question;
import fr.dawan.projweb.entites.Reponse;
import junit.framework.TestCase;

public class QcmDaoTest extends TestCase {

	// fabrique de connexions qui va charger
	// la conf du persistence.xml
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistence-unit");

//	@Test
//	public void testInsertionQcm() {
//
//		try {
//
//			Qcm qcm1 = new Qcm();
//			qcm1.setSujet("JAVA");
//
//			Question qst1 = new Question();
//			qst1.setEnonce("Comment déclarer une constante ?");
//			qst1.setMultiple(false);
//			qst1.setOrdre(1);
//			qst1.setQcm(qcm1);
//			
//			Reponse rep1 = new Reponse();
//			rep1.setQuestion(qst1);
//			rep1.setCorrecte(true);
//			rep1.setTexte("final type NOM = VALEUR;");
//			
//			EntityManager em = emf.createEntityManager();
//			GenericDao.saveOrUpdate(rep1, rep1.getId(), 
//									em, false);
//			
//			Reponse rep2 = new Reponse();
//			rep2.setQuestion(qst1);
//			rep2.setCorrecte(false);
//			rep2.setTexte("const NOM = VALEUR;");
//			
//			GenericDao.saveOrUpdate(rep2, rep2.getId(), 
//									em, false);
//			
//			Question qst2 = new Question();
//			qst2.setEnonce("Comment créer un objet ?");
//			qst2.setMultiple(true);
//			qst2.setOrdre(2);
//			qst2.setQcm(qcm1);
//
//			Reponse rep21 = new Reponse();
//			rep21.setQuestion(qst2);
//			rep21.setCorrecte(true);
//			rep21.setTexte("en instanciant sa classe");
//			
//			GenericDao.saveOrUpdate(rep21, rep21.getId(), 
//									em, false);
//			
//			Reponse rep22 = new Reponse();
//			rep22.setQuestion(qst2);
//			rep22.setCorrecte(true);
//			rep22.setTexte("en appelant une méthode static renvoyant une instance");
//			
//			GenericDao.saveOrUpdate(rep22, rep22.getId(), 
//									em, false);
//			
//			Reponse rep23 = new Reponse();
//			rep23.setQuestion(qst2);
//			rep23.setCorrecte(false);
//			rep23.setTexte("en le déclarant #define");
//			
//			GenericDao.saveOrUpdate(rep23, rep23.getId(), 
//									em, true);
//			
//			
//			assertTrue(true);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
//	}

	@Test
	public void testFindQuestion() {
		try {
			EntityManager em = emf.createEntityManager();
			Question qst = QcmDao.findQuestion(2L, 1, em, true);
			assertNotNull(qst);
			assertEquals("Comment déclarer une constante ?", qst.getEnonce());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testFindReponses() {
		try {
			EntityManager em = emf.createEntityManager();
			List<Reponse> lRep = QcmDao.findReponses(2, em, false);
			assertNotNull(lRep);
			assertEquals(5, lRep.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	
	
}
