
package fr.dawan.projsoap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour additionResponse complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="additionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionResponse", propOrder = {
    "resultat"
})
public class AdditionResponse {

    protected int resultat;

    /**
     * Obtient la valeur de la propri�t� resultat.
     * 
     */
    public int getResultat() {
        return resultat;
    }

    /**
     * D�finit la valeur de la propri�t� resultat.
     * 
     */
    public void setResultat(int value) {
        this.resultat = value;
    }

}
