package fr.dawan.manipXmlF;

import java.io.File;

import fr.dawan.manipJson.JsonTools;
import junit.framework.TestCase;

public class JsonToolsTest extends TestCase {

	public void testToJson() {
		Produit p = new Produit();
		p.setId(1);
		p.setDescription("Valise");
		p.setPrix(153.99);

		try {
			JsonTools.toJson("test.json", p);
			System.out.println("Création du fichier 1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Erreur lors de l'écriture fichier 1 :\n" + e.getMessage());
		}

		try {
			JsonTools.toJsonGen("testG.json", p);
			System.out.println("Création du fichier 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Erreur lors de l'écriture fichier 2 :\n" + e.getMessage());
		}

		try {
			JsonTools.genericToJson("testG2.json", p);
			System.out.println("Création du fichier 3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Erreur lors de l'écriture fichier 3 :\n" + e.getMessage());
		}

		try {
			File file = new File("test.json");
			assertTrue(file.exists());
			System.out.println("Fichier 1 généré");
			File file2 = new File("testG.json");
			assertTrue(file2.exists());
			System.out.println("Fichier 2 généré");
			File file3 = new File("testG2.json");
			assertTrue(file3.exists());
			System.out.println("Fichier 3 généré");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Le fichier n'existe pas :\n" + e.getMessage());
		}

		try {
			Produit p2 = JsonTools.fromJsonGen("test.json", Produit.class);
			assertEquals(p2.getId(), p.getId());
			assertEquals(p2.getDescription(), p.getDescription());
			assertEquals(p2.getPrix(), p.getPrix());
			System.out.println("Le fichier 1 existe");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Le fichier 1 n'existe pas :\n" + e.getMessage());
		}

		try {
			Produit p3 = JsonTools.fromJsonGen("testG.json", Produit.class);
			assertEquals(p3.getId(), p.getId());
			assertEquals(p3.getDescription(), p.getDescription());
			assertEquals(p3.getPrix(), p.getPrix());
			System.out.println("Le fichier 2 existe");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Le fichier 2 n'existe pas :\n" + e.getMessage());
		}

		try {
			Produit p4 = JsonTools.fromJsonGen("testG2.json", Produit.class);
			assertEquals(p4.getId(), p.getId());
			assertEquals(p4.getDescription(), p.getDescription());
			assertEquals(p4.getPrix(), p.getPrix());
			System.out.println("Le fichier 3 existe");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Le fichier 3 n'existe pas :\n" + e.getMessage());
		}

	}

}
