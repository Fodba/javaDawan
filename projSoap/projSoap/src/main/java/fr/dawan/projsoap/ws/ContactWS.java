package fr.dawan.projsoap.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.dawan.projsoap.ws.dao.ContactDao;
import fr.dawan.projsoap.ws.entites.Contact;

@WebService
public class ContactWS {

	@WebMethod
	public List<Contact> findAll() {
		return ContactDao.findAll();
	}

	// findAllXml
	@WebMethod
	public @WebResult(name = "liste-contact") List<Contact> findAllXml() {
		return ContactDao.findAll();
	}

	// findById
	@WebMethod
	public @WebResult(name = "contact") Contact findById(@WebParam(name = "id") long id) throws Exception {
		return ContactDao.findById(id);
	}

	// Insert
	@WebMethod
	public @WebResult(name = "resultat") String insert(@WebParam(name = "contact") Contact p) {
		try {
			ContactDao.add(p);
			return "INSERTED";
		} catch (Exception e) {
			return "Echec de l'insertion";
		}
	}

	// update
	@WebMethod
	public @WebResult(name = "resultat") String update(@WebParam(name = "contact") Contact p) {
		try {
			ContactDao.update(p);
			return "UPDATED";
		} catch (Exception e) {
			return "Echec de la modification";
		}
	}

	// delete
	@WebMethod
	public @WebResult(name = "resultat") String remove(@WebParam(name = "id") long id) throws Exception {
		try {
			ContactDao.remove(id);
			return "REMOVED";
		} catch (Exception e) {
			return "Echec de la suppression";
		}
	}

}
