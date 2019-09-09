package fr.dawan.clientWs;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.clientWs.entites.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final static String WS_BASE_URL = "http://localhost:8080/spring/api/produits";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		try {
			model.addAttribute("productForm", new Product());
			final Client client = ClientBuilder.newClient().register(JacksonFeature.class);
			List<Product> products = findProductFromWS(client);
			model.addAttribute("products", products);
			client.close();

		} catch (Exception e) {
			model.addAttribute("msg", "Erreur : " + e.getMessage());
		}
		return "home";
	}

	private List<Product> findProductFromWS(Client client) throws Exception {
		final Response res = client.target(WS_BASE_URL).request().get();
		if (res.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + res.getStatus());
		}
		GenericType<List<Product>> prodsType = new GenericType<List<Product>>() {
		};
		List<Product> prods = res.readEntity(prodsType);
		return prods;
	}

	@GetMapping(value = "/suppression/{id}")
	private String suppression(@PathVariable("id") long id, Locale locale, Model model) {
		try {

			final Client client = ClientBuilder.newClient().register(JacksonFeature.class);
			final Response res = client.target(WS_BASE_URL + "/delete/" + id).request().get();
			client.close();

		} catch (Exception e) {
			model.addAttribute("msg", "Erreur : " + e.getMessage());
		}
		return "redirect:/";
	}

//	@PostMapping(value = "/modification/{id}")
//	private String modification(@Valid @ModelAttribute("ProductForm") Product product, @PathVariable("id") long id,
//			BindingResult br, Model model) {
//
//		// Vérification du résultat de la validation
//		if (br.hasErrors()) {
//			return "redirect:/";
//		}
//
//		try {
//
////			// Cas de création car l'id n'est pas renseigné
////			if (productForm.getId() == null) {
////				// Il faut maintenant convertir le user du bean (UserManagementForm) en user
////				// pour les DAO (User)
////				Product p = new Product(0, Float.parseFloat(productForm.getPrice()), productForm.getDescription(),
////						Date.parse(productForm.getPurchaseDate())., productForm.getState());
////
////				// ci-dessous équivalent à la ligne juste au dessus
//////				User u = new User();
//////				u.setEmail(userForm.getEmail());
//////				u.setId(0);
//////				u.setNom(userForm.getNom());
//////				u.setPassword(userForm.getPassword());
//////				u.setVersion(0);
////
////				userService.create(p);
////			}
//
//			final Client client = ClientBuilder.newClient().register(JacksonFeature.class);
//			final Response res = client.target(WS_BASE_URL + "/save/" + id).request()
//					.post(Entity.entity(product, MediaType.APPLICATION_JSON));
//			client.close();
//
//		} catch (Exception e) {
//			model.addAttribute("msg", "Erreur : " + e.getMessage());
//		}
//		return "redirect:/";
//	}

	@PostMapping("/saveProduct")
	public String saveProduct(Model m, @ModelAttribute("productForm") Product p, BindingResult result) {
		Client client = null;
		try {
			String saveUrl = WS_BASE_URL + "/save";
			if (p.getId() != 0)
				saveUrl = WS_BASE_URL + "/update";

			client = ClientBuilder.newClient().register(JacksonFeature.class);
			final Response res = client.target(saveUrl).request().post(Entity.entity(p, MediaType.APPLICATION_JSON));
			if (res.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + res.getStatus());
			}

			String rep = res.readEntity(String.class);
			m.addAttribute("msg", rep);

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "Erreur : " + e.getMessage());
		} finally {
			client.close();
		}
		return "redirect:/";
	}

//	@GetMapping("/modifier/{id}")
//	public String modification(@PathVariable("id") long id, Model model) {
//		final Client client = ClientBuilder.newClient().register(JacksonFeature.class);
//		final Response res = client.target(WS_BASE_URL + "/" + id).request().get();
//
//		GenericType<List<Product>> prodsType = new GenericType<List<Product>>() {
//		};
//		List<Product> prods = res.readEntity(prodsType);
//		Product produit = prods.get(0);
//		model.addAttribute("productForm", produit);
//
//		client.close();
//
//		return home(model);
//	}

	@GetMapping("/modification/{id}")
	public String modifier(@PathVariable("id") long id, Model model) {

		// trouver le produit par rapport à son id
		Client client = null;
		try {

			client = ClientBuilder.newClient().register(JacksonFeature.class);
			final Response res = client.target(WS_BASE_URL + "/" + id).request().get();

			if (res.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + res.getStatus());
			}

			Product p = res.readEntity(Product.class);
			model.addAttribute("productForm", p);

			List<Product> products = findProductFromWS(client);
			model.addAttribute("products", products);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Erreur : " + e.getMessage());
		} finally {
			client.close();
		}

		return "home";
	}

}