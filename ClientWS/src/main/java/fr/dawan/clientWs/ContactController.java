package fr.dawan.clientWs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.clientWs.forms.ContactForm;
import fr.dawan.projsoap.ws.Contact;
import fr.dawan.projsoap.ws.ContactWS;
import fr.dawan.projsoap.ws.ContactWSService;
import fr.dawan.projsoap.ws.Exception_Exception;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@GetMapping
	public String listContact(Model model) {
		ContactWS serv = new ContactWSService().getContactWSPort();
		List<Contact> fa = serv.findAll();
		model.addAttribute("contacts", fa);
		model.addAttribute("contactForm", new Contact());
		String s1 = "test";
		s1 += " la concatenation";
		model.addAttribute("msg", s1);
		return "contact";
	}

	@GetMapping("/{id}")
	public String oneContact(@PathVariable("id") long id, Model model) {
		ContactWS serv = new ContactWSService().getContactWSPort();
		Contact c = null;
		try {
			c = serv.findById(id);
			model.addAttribute("contact", c);
			model.addAttribute("contactForm", new Contact());
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "contact";
	}

	@PostMapping("/inserer")
	public String inserer(@ModelAttribute("contactForm") Contact contactForm, BindingResult br, Model model) {
		ContactWS serv = new ContactWSService().getContactWSPort();

//		Contact contact;
//			contact = serv.findById(contactForm.getId());
		String resultat = "";
		long id = contactForm.getId();
		if (id == 0) {
			resultat = serv.insert(contactForm);
		} else {
			resultat = serv.update(contactForm);
		}

		List<Contact> fa = serv.findAll();
		model.addAttribute("contacts", fa);
		model.addAttribute("msg", "Resultat = " + resultat);
		model.addAttribute("contactForm", contactForm);

		return "contact";
	}

	@GetMapping("/suppression/{id}")
	public String supprimer(@PathVariable("id") long id, Model model) {
		ContactWS serv = new ContactWSService().getContactWSPort();

		String resultat = "";
		List<Contact> fa = null;
		try {
			resultat = serv.remove(id);
			fa = serv.findAll();
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultat = "Erreur lors de la suppression" + e.getMessage();
		}
		model.addAttribute("contacts", fa);
		model.addAttribute("msg", "Resultat = " + resultat);
		model.addAttribute("contactForm", new ContactForm());
		return "contact";
	}

	@GetMapping("/modification/{id}")
	public String modifier(@ModelAttribute("contactForm") Contact contactForm, @PathVariable("id") long id,
			BindingResult br, Model model) {
		ContactWS serv = new ContactWSService().getContactWSPort();

//		Contact contact;
//			contact = serv.findById(contactForm.getId());
		Contact contact = null;
		List<Contact> fa = null;
		try {
			contact = serv.findById(id);
			fa = serv.findAll();

			contactForm.setId(contact.getId());
			contactForm.setVersion(contact.getVersion());
			contactForm.setPrenom(contact.getPrenom());
			contactForm.setNom(contact.getNom());
			contactForm.setTelephone(contact.getTelephone());
			contactForm.setAdresse(contact.getAdresse());
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("contacts", fa);
		model.addAttribute("msg", "Resultat = sélection du contact à modifier");
		model.addAttribute("contactForm", contactForm);

		return "contact";
	}

}
