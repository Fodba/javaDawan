
package fr.dawan.projsoap.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAllXmlResponse", namespace = "http://ws.projsoap.dawan.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllXmlResponse", namespace = "http://ws.projsoap.dawan.fr/")
public class FindAllXmlResponse {

    @XmlElement(name = "liste-contact", namespace = "")
    private List<fr.dawan.projsoap.ws.entites.Contact> listeContact;

    /**
     * 
     * @return
     *     returns List<Contact>
     */
    public List<fr.dawan.projsoap.ws.entites.Contact> getListeContact() {
        return this.listeContact;
    }

    /**
     * 
     * @param listeContact
     *     the value for the listeContact property
     */
    public void setListeContact(List<fr.dawan.projsoap.ws.entites.Contact> listeContact) {
        this.listeContact = listeContact;
    }

}
