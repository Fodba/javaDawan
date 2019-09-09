package fr.dawan.manipXmlF;

import javax.xml.bind.JAXBException;

import fr.dawan.entreprise.Salarie;
import fr.dawan.entreprise.Societe;
import junit.framework.TestCase;

public class XmlToolsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testXml() {

		Produit p = new Produit(1, "Valise", 1234);

		/* TEST DE L'EXPORT */
		try {
			XmlTools.toXml("toto.xml", p, "fr.dawan.manipXmlF");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erreur export XML: " + e.getMessage());
		}

		/* TEST DE L'IMPORT */
		try {
			/* Création d'un produit à partir du fichier XML */
			Produit prod = (Produit) XmlTools.fromXml("toto.xml", "fr.dawan.manipXmlF");

			/* On compare le nouveau produit avec celui qu'on a exporté */
			assertEquals(prod.getId(), p.getId());
			assertEquals(prod.getDescription(), p.getDescription());
			assertEquals(prod.getPrix(), p.getPrix());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erreur import XML: " + e.getMessage());
		}
	}

	public void testXmlSociete() throws JAXBException {

		Salarie s1 = new Salarie("toto", "PDG", "0123456789");

		Societe soc = new Societe();
		soc.setRaisonSociale("Mon entreprise");
		soc.getSalarie().add(s1);

		try {
			String jaxbPath = "fr.dawan.entreprise";

			XmlTools.toXml("societe.xml", soc, jaxbPath);

			Societe prod = (Societe) XmlTools.fromXml("societe.xml", jaxbPath);

			assertEquals(prod.getRaisonSociale(), soc.getRaisonSociale());
			assertEquals(prod.getSiret(), soc.getSiret());
			assertEquals(prod.getSalarie().size(), soc.getSalarie().size());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erreur import XML: " + e.getMessage());
		}
	}
}
