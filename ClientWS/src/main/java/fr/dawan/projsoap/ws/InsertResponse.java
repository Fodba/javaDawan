
package fr.dawan.projsoap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour insertResponse complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="insertResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertResponse", propOrder = {
    "resultat"
})
public class InsertResponse {

    protected String resultat;

    /**
     * Obtient la valeur de la propri�t� resultat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultat() {
        return resultat;
    }

    /**
     * D�finit la valeur de la propri�t� resultat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultat(String value) {
        this.resultat = value;
    }

}
