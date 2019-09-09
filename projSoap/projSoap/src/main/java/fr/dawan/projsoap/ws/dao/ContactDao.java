package fr.dawan.projsoap.ws.dao;

import java.util.ArrayList;
import java.util.List;

import fr.dawan.projsoap.ws.entites.Contact;

public class ContactDao {

	private static List<Contact> lc;

	static {
		lc = new ArrayList<Contact>();
		Contact p1 = new Contact(0, "FADIKA", "Mauro", "0102030405", "Rue de la paix");
		p1.setId(1L);
		lc.add(p1);
		Contact p2 = new Contact(0, "GUERINOT", "Théo", "0102030405", "Rue de la bagarre");
		p2.setId(2L);
		lc.add(p2);
		Contact p3 = new Contact(0, "JEANNIN", "Jessy", "0102030405", "Rue de la médiation");
		p3.setId(3L);
		lc.add(p3);
		Contact p4 = new Contact(0, "De Richter", "Olivier", "0102030405", "Rue de la médiation");
		p4.setId(4L);
		lc.add(p4);
	}

	public static List<Contact> findAll() {
		return lc;
	}

	public static Contact findById(long id) throws Exception {
//                for(Contact p : lc) {
//                        if(p.getId()==id)
//                                return p;
//                }
//                return null;
		return lc.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	public static void add(Contact p) {
		p.setId(lc.size() + 1);
		lc.add(p);
	}

	public static void update(Contact p) throws Exception {
		int pos = lc.indexOf(p);
		if (pos != -1)
			lc.set(pos, p);
		else
			throw new Exception("Erreur : produit inexistant !");
	}

	public static void remove(long id) throws Exception {
		Contact p = new Contact();
		p.setId(id);
		int pos = lc.indexOf(p);
		if (pos != -1)
			lc.remove(pos);
		else
			throw new Exception("Erreur : produit inexistant !");
	}

}
