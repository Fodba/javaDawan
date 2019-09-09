//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.08.26 � 03:02:05 PM CEST 
//

package fr.dawan.entreprise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour anonymous complex type.
 * 
 * <p>
 * Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette
 * classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="poste" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numSS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nom", "poste" })
public class Salarie {

	@XmlElement(required = true)
	protected String nom;
	@XmlElement(required = true)
	protected String poste;
	@XmlAttribute(name = "numSS")
	protected String numSS;

	/**
	 * Obtient la valeur de la propri�t� nom.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * D�finit la valeur de la propri�t� nom.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * Obtient la valeur de la propri�t� poste.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPoste() {
		return poste;
	}

	/**
	 * D�finit la valeur de la propri�t� poste.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPoste(String value) {
		this.poste = value;
	}

	/**
	 * Obtient la valeur de la propri�t� numSS.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumSS() {
		return numSS;
	}

	/**
	 * D�finit la valeur de la propri�t� numSS.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNumSS(String value) {
		this.numSS = value;
	}

	public Salarie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salarie(String nom, String poste, String numSS) {
		super();
		this.nom = nom;
		this.poste = poste;
		this.numSS = numSS;
	}

}
