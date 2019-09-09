package fr.dawan.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.spring.entities.Product;

@Repository
public class ProductDao {
	@PersistenceContext
	private EntityManager em;

	public void create(Product Product) {
		try {

			em.persist(Product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> readAll() {
		try {
			return em.createQuery("From Product").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Product readById(long id) {
		try {
			return (Product) em.createQuery("From Product u WHERE id = :id").setParameter("id", id).getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void delete(Product Product) {
		try {
			em.remove(Product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void update(Product Product) {
		try {
			em.merge(Product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public long count() {
		try {
			return (long) em.createQuery("select count(x) FROM Product x").getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> readPartial(int start, int nbElements) {
		try {
			return em.createQuery("From Product").setFirstResult(start).setMaxResults(nbElements).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
