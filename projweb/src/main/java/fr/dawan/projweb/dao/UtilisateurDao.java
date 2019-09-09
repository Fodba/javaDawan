package fr.dawan.projweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.projweb.entites.Question;
import fr.dawan.projweb.entites.Reponse;
import fr.dawan.projweb.entites.Utilisateur;

public class UtilisateurDao {

	
	@SuppressWarnings("unchecked")
	public static Utilisateur findByEmail(String email, EntityManager em, boolean closeCnx) {
		Utilisateur u = null;
		EntityTransaction tx = em.getTransaction();
		try {
			String req = "FROM Utilisateur u WHERE u.email= :email";
			tx.begin();
			List<Utilisateur> res = em.createQuery(req)
					.setParameter("email", email)
					.getResultList();
			if (res != null && res.size() > 0)
				u = res.get(0);
			tx.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (closeCnx)
				em.close();
		}
		return u;
	}

	/*
	 * JP-QL (HQL) : FROM Question qst WHERE qst.qcm.id = :idQcm AND qst.ordre=
	 * :ordre
	 * 
	 * SQL natif : select * from t_questions qst where qst.qcm_id = ? AND ordre = ?
	 * 
	 */

	// public static List<Reponse> findReponses(long idQuestion)
	// FROM Reponse rep WHERE rep.question.id = :idQuestion
	@SuppressWarnings("unchecked")
	public static List<Reponse> findReponses(long idQuestion, EntityManager em, boolean closeCnx) {
		List<Reponse> lRep = null;
		EntityTransaction tx = em.getTransaction();
		try {
			String req = "FROM Reponse rep WHERE rep.question.id= :idQuestion";
			tx.begin();
			lRep = em.createQuery(req)
					.setParameter("idQuestion", idQuestion)
					.getResultList();
			tx.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (closeCnx)
				em.close();
		}
		return lRep;
	}

}
