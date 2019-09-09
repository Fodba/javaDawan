
package fr.dawan.projsoap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.dawan.projsoap.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Insert_QNAME = new QName("http://ws.projsoap.dawan.fr/", "insert");
    private final static QName _Update_QNAME = new QName("http://ws.projsoap.dawan.fr/", "update");
    private final static QName _RemoveResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "removeResponse");
    private final static QName _FindAll_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findAll");
    private final static QName _Exception_QNAME = new QName("http://ws.projsoap.dawan.fr/", "Exception");
    private final static QName _InsertResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "insertResponse");
    private final static QName _Remove_QNAME = new QName("http://ws.projsoap.dawan.fr/", "remove");
    private final static QName _FindAllResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findAllResponse");
    private final static QName _FindAllXml_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findAllXml");
    private final static QName _FindAllXmlResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findAllXmlResponse");
    private final static QName _UpdateResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "updateResponse");
    private final static QName _Contact_QNAME = new QName("http://ws.projsoap.dawan.fr/", "contact");
    private final static QName _FindById_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://ws.projsoap.dawan.fr/", "findByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.dawan.projsoap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllXmlResponse }
     * 
     */
    public FindAllXmlResponse createFindAllXmlResponse() {
        return new FindAllXmlResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindAllXml }
     * 
     */
    public FindAllXml createFindAllXml() {
        return new FindAllXml();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findAllXml")
    public JAXBElement<FindAllXml> createFindAllXml(FindAllXml value) {
        return new JAXBElement<FindAllXml>(_FindAllXml_QNAME, FindAllXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findAllXmlResponse")
    public JAXBElement<FindAllXmlResponse> createFindAllXmlResponse(FindAllXmlResponse value) {
        return new JAXBElement<FindAllXmlResponse>(_FindAllXmlResponse_QNAME, FindAllXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Contact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "contact")
    public JAXBElement<Contact> createContact(Contact value) {
        return new JAXBElement<Contact>(_Contact_QNAME, Contact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.projsoap.dawan.fr/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

}
