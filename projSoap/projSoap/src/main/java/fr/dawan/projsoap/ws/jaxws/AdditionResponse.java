
package fr.dawan.projsoap.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "additionResponse", namespace = "http://ws.projsoap.dawan.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionResponse", namespace = "http://ws.projsoap.dawan.fr/")
public class AdditionResponse {

    @XmlElement(name = "resultat", namespace = "")
    private int resultat;

    /**
     * 
     * @return
     *     returns int
     */
    public int getResultat() {
        return this.resultat;
    }

    /**
     * 
     * @param resultat
     *     the value for the resultat property
     */
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

}
