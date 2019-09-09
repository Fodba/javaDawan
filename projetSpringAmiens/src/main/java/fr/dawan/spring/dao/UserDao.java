package fr.dawan.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.spring.entities.User;

@Repository
public class UserDao {
	@PersistenceContext
	private EntityManager em;

	public void create(User user) {
		try {

			em.persist(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> readAll() {
		try {
			return em.createQuery("From User").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public User readById(long id) {
		try {
			return (User) em.createQuery("From User u WHERE id = :id").setParameter("id", id).getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public User readByEmail(String email) {
		try {
			return (User) em.createQuery("From User u WHERE email = :email").setParameter("email", email)
					.getSingleResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void delete(User user) {
		try {
			em.remove(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void update(User user) {
		try {
			em.merge(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public long count() {
		try {
			return (long) em.createQuery("select count(x) FROM User x").getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> readPartial(int start, int nbElements) {
		try {
			return em.createQuery("From User").setFirstResult(start).setMaxResults(nbElements).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
