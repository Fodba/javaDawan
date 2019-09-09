
package fr.dawan.projsoap.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertResponse", namespace = "http://ws.projsoap.dawan.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertResponse", namespace = "http://ws.projsoap.dawan.fr/")
public class InsertResponse {

    @XmlElement(name = "resultat", namespace = "")
    private String resultat;

    /**
     * 
     * @return
     *     returns String
     */
    public String getResultat() {
        return this.resultat;
    }

    /**
     * 
     * @param resultat
     *     the value for the resultat property
     */
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

}
