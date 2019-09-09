package fr.dawan.projetjaxrs.ws.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.dawan.projetjaxrs.ws.entites.Product;

public class ProductDao {

	private static List<Product> lp;

	static {
		lp = new ArrayList<Product>();
		Product p1 = new Product(0, 10, "valise", new Date(), Product.ProductState.VG);
		p1.setId(1L);
		lp.add(p1);
		Product p2 = new Product(0, 10, "sac", new Date(), Product.ProductState.VG);
		p2.setId(2L);
		lp.add(p2);
	}

	public static List<Product> findAll() {
		return lp;
	}

	public static Product findById(long id) throws Exception {
//                for(Product p : lp) {
//                        if(p.getId()==id)
//                                return p;
//                }
//                return null;
		return lp.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	public static void add(Product p) {
		p.setId(lp.size() + 1);
		lp.add(p);
	}

	public static void update(Product p) throws Exception {
		int pos = lp.indexOf(p);
		if (pos != -1)
			lp.set(pos, p);
		else
			throw new Exception("Erreur : produit inexistant !");
	}

	public static void remove(long id) throws Exception {
		Product p = new Product();
		p.setId(id);
		int pos = lp.indexOf(p);
		if (pos != -1)
			lp.remove(pos);
		else
			throw new Exception("Erreur : produit inexistant !");
	}

}