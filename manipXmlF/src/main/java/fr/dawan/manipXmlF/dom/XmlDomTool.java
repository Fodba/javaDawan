package fr.dawan.manipXmlF.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTool {

	public XmlDomTool() {
		// TODO Auto-generated constructor stub
	}

	// JAXP: Java API for Xml Parsing
	public static void main(String[] args) {
		/*
		 * <?xml version="1.0"?>
		 * 
		 * <annuaire> <!-- Commentaire sous la racine --> <personne id="0"> <nom>un
		 * nom</nom> <prenom>un prenom</prenom> <adresse>une adresse</adresse>
		 * </personne> </annuaire>
		 */
		try {

			// Création d'un nouveau DOM
			DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructeur = fabrique.newDocumentBuilder();
			Document document = constructeur.newDocument();

			// Propriétés du DOM
			document.setXmlVersion("1.0");
			document.setXmlStandalone(true);

			// Création de l'arborescence du DOM
			Element racine = document.createElement("annuaire");
			racine.appendChild(document.createComment("Commentaire sous la racine"));

			Element personne = document.createElement("personne");
			personne.setAttribute("id", "1");

			Element nom = document.createElement("nom");
			nom.setTextContent("un nom");
			personne.appendChild(nom);

			Element prenom = document.createElement("prenom");
			prenom.setTextContent("un pr�nom");
			personne.appendChild(prenom);

			Element adresse = document.createElement("adresse");
			adresse.setTextContent("une adresse");
			personne.appendChild(adresse);

			racine.appendChild(personne);

			document.appendChild(racine);

			/**********************
			 * Sauvegarde du DOM dans un fichier XML
			 *******************/
			// Création de la source DOM
			Source source = new DOMSource(document);

			// Création du fichier de sortie
			Result resultat = new StreamResult("testDOM.xml");

			// Configuration du transformer
			TransformerFactory fabri = TransformerFactory.newInstance();
			Transformer transformer = fabri.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// Transformation
			transformer.transform(source, resultat);
			System.out.println("Ecriture terminée...");

			// ----------------------LECTURE
//			NodeList listPersonne = document.getElementsByTagName("personne");
//
//			if (listPersonne != null && listPersonne.getLength() > 0) {
//				Node noeudPersonne = listPersonne.item(0);
////				Node valeurNom = listPersonne.getChildNodes();
//
//				NamedNodeMap namedNodeMap = noeudPersonne.getAttributes();
//				Node noeudId = namedNodeMap.getNamedItem("id");
//				System.out.println(noeudPersonne.getTextContent());
//
//			}

			// ______________ lecture
			// utiliser la méthode
			// document.getElementByTagName
			// pour afficher l'id de la personne
			// et les balises enfants
			NodeList listPer = document.getElementsByTagName("personne");
			if (listPer != null && listPer.getLength() > 0) {
				Node noeudPersonne = listPer.item(0);
				// attributs : noeudPersonne.getAttributes()
				NamedNodeMap attMap = noeudPersonne.getAttributes();
				Node noeudId = attMap.getNamedItem("id");
				System.out.println("id = " + noeudId.getNodeValue());
				// enfants :
				NodeList enfants = noeudPersonne.getChildNodes();
				for (int i = 0; i < enfants.getLength(); i++) {
					Node nEnf = enfants.item(i);
					System.out.println(nEnf.getNodeName() + " = " + nEnf.getTextContent());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
