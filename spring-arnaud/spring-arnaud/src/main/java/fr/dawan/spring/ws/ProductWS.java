package fr.dawan.spring.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.spring.dao.ProductDao;
import fr.dawan.spring.entities.Product;

@RestController
@RequestMapping("/api/produits")
public class ProductWS {

	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@GetMapping(produces = "application/json")
	@ResponseBody
	public List<Product> findAll() {
		return productDao.readAll();
	}

	@GetMapping(value = "xml", produces = "application/xml")
	@ResponseBody
	public List<Product> findAllXml() {
		return productDao.readAll();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public @ResponseBody Product findById(@PathVariable("id") long id) {
		return productDao.readById(id);
	}

	@PostMapping(value = "/save", produces = "text/plain", consumes = "application/json")
	public String insert(@RequestBody Product p) {
		try {
			productDao.create(p);
			return "INSERTED";
		} catch (Exception e) {
			return "Erreur lors de l'insertion : " + e.getMessage();
		}
	}

	@PostMapping(value = "/update", produces = "text/plain", consumes = "application/json")
	public String patch(@RequestBody Product p) {
		try {
			productDao.update(p);
			return "UPDATED";
		} catch (Exception e) {
			return "Erreur lors de la modification : " + e.getMessage();
		}
	}

	@GetMapping(value = "/delete/{id}", produces = "text/plain")
	public String delete(@PathVariable("id") long id) {
		try {
			productDao.delete(id);
			return "DELETED";
		} catch (Exception e) {
			return "Erreur lors de la suppression : " + e.getMessage();
		}
	}

}
