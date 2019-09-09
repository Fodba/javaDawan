
package fr.dawan.projsoap.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "update", namespace = "http://ws.projsoap.dawan.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", namespace = "http://ws.projsoap.dawan.fr/")
public class Update {

    @XmlElement(name = "contact", namespace = "")
    private fr.dawan.projsoap.ws.entites.Contact contact;

    /**
     * 
     * @return
     *     returns Contact
     */
    public fr.dawan.projsoap.ws.entites.Contact getContact() {
        return this.contact;
    }

    /**
     * 
     * @param contact
     *     the value for the contact property
     */
    public void setContact(fr.dawan.projsoap.ws.entites.Contact contact) {
        this.contact = contact;
    }

}
