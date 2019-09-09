
package fr.dawan.projsoap.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAllResponse", namespace = "http://ws.projsoap.dawan.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllResponse", namespace = "http://ws.projsoap.dawan.fr/")
public class FindAllResponse {

    @XmlElement(name = "return", namespace = "")
    private List<fr.dawan.projsoap.ws.entites.Contact> _return;

    /**
     * 
     * @return
     *     returns List<Contact>
     */
    public List<fr.dawan.projsoap.ws.entites.Contact> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<fr.dawan.projsoap.ws.entites.Contact> _return) {
        this._return = _return;
    }

}
