package fr.dawan.manipXmlF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlTools {

	/**
	 * Sérialisation d'un objet en Xml
	 * 
	 * @param <T>      un type quelconque (sa classe sera annotée)
	 * @param filePath chemin du fichier de destination
	 * @param obj      objet à sérialiser
	 * @throws JAXBException
	 */
	public static <T> void toXml(String filePath, T obj, String jaxbPackage) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(jaxbPackage);
		Marshaller m = context.createMarshaller();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			m.marshal(obj, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromXml(String filePath, String jaxbPackage) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(jaxbPackage);
		Unmarshaller m = context.createUnmarshaller();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			T p = (T) m.unmarshal(reader);
			return p;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromXml2(String filePath, String jaxbPackage) throws Exception {
		JAXBContext context = JAXBContext.newInstance(jaxbPackage);
		Unmarshaller m = context.createUnmarshaller();
		Object obj = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			obj = m.unmarshal(reader);
		}
		return (T) obj;
	}

	public static void main(String[] args) {
		Produit p = new Produit(1, "Valise", 1234);

		try {
			XmlTools.toXml("toto.xml", p, "fr.dawan.manipXmlF");
			System.out.println("XML Généré");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Produit prod = (Produit) XmlTools.fromXml("toto.xml", "fr.dawan.manipXmlF");
			System.out.println(prod.getId());
			System.out.println(prod.getDescription());
			System.out.println(prod.getPrix());
			System.out.println("XML Lu avec succès");
			Produit prod2 = (Produit) XmlTools.fromXml2("toto.xml", "fr.dawan.manipXmlF");
			System.out.println(prod2.getId());
			System.out.println(prod2.getDescription());
			System.out.println(prod2.getPrix());
			System.out.println("XML Lu avec succès");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
