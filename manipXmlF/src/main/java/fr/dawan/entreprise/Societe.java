//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.08.26 � 03:02:05 PM CEST 
//

package fr.dawan.entreprise;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="raisonSociale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="salarie" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="poste" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="numSS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="siret" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "raisonSociale", "salarie" })
@XmlRootElement(name = "societe")
public class Societe {

	@XmlElement(required = true)
	protected String raisonSociale;
	protected List<Salarie> salarie;
	@XmlAttribute(name = "siret", required = true)
	protected String siret;

	/**
	 * Obtient la valeur de la propri�t� raisonSociale.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRaisonSociale() {
		return raisonSociale;
	}

	/**
	 * D�finit la valeur de la propri�t� raisonSociale.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRaisonSociale(String value) {
		this.raisonSociale = value;
	}

	/**
	 * Gets the value of the salarie property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the salarie property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSalarie().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Salarie }
	 * 
	 * 
	 */
	public List<Salarie> getSalarie() {
		if (salarie == null) {
			salarie = new ArrayList<Salarie>();
		}
		return this.salarie;
	}

	/**
	 * Obtient la valeur de la propri�t� siret.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * D�finit la valeur de la propri�t� siret.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSiret(String value) {
		this.siret = value;
	}

	public Societe(String raisonSociale, List<Salarie> salarie, String siret) {
		super();
		this.raisonSociale = raisonSociale;
		this.salarie = salarie;
		this.siret = siret;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

	}
}
