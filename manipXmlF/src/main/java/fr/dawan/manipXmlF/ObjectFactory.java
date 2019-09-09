package fr.dawan.manipXmlF;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public Produit createProduit() {
		return new Produit();
	}
}
