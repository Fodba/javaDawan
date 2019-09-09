package fr.dawan.projetjaxrs.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.dawan.projetjaxrs.ws.dao.ProductDao;
import fr.dawan.projetjaxrs.ws.entites.Product;

@Path("/products")
public class ProductWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findAll() {
		return ProductDao.findAll();
	}

	// findAllXml
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Product> findAllXml() {
		return ProductDao.findAll();
	}

	// findById
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product findById(@PathParam ("id") long id) throws Exception {
		return ProductDao.findById(id);
	}

	// Insert
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(Product p) {
		try {
			ProductDao.add(p);
			return "INSERTED";
		} catch (Exception e) {
			return "Echec de l'insertion";
		}
	}

	// update
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Product p) {
		try {
			ProductDao.update(p);
			return "UPDATED";
		} catch (Exception e) {
			return "Echec de la modification";
		}
	}

	// delete
	@GET
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String remove(@PathParam ("id") long id) throws Exception {
		try {
			ProductDao.remove(id);
			return "REMOVED";
		} catch (Exception e) {
			return "Echec de la suppression";
		}
	}
	
	@GET
	@Path("/testint")
	@Produces(MediaType.APPLICATION_JSON)
	public int testInt(){
		int result = 20;
		return result;
	}
	
	
	
}