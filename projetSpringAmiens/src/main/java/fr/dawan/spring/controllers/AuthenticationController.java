package fr.dawan.spring.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.spring.beans.UserForm;
import fr.dawan.spring.entities.User;
import fr.dawan.spring.service.UserService;

@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController {

	@Autowired
	private UserService us;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/")
	public String display(Model model) {

		// model.addAttribute("monBean", new ExempleForm()); // plus besoin de mettre
		// cette ligne si on a une méthode comme ligne 105 avec l'annotation
		// @ModelAttribute

		return "home"; // mettre directement le nom exacte de la page, spring s'occupe
		// /WEB-INF/views/exemple.jsp
	}

	@RequestMapping("/authentication")
	public String authentication(@ModelAttribute("monForm") @Valid UserForm monForm, BindingResult br, Model model,
			Locale locale) {

		if (br.hasErrors()) {
			return "home";
		}

		try {
			String email = monForm.getEmail();
			String password = monForm.getPassword().trim();

			User user = us.readByEmail(email);

			System.out.println(password);
			System.out.println(user.getPassword());

			if (user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "dashboard";
			} else {
				model.addAttribute("msg", messageSource.getMessage("authentication.errors", null, locale));
//				model.addAttribute("msg", "Votre mot de passe n'existe pas");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping("/authentication/{param1}")
	public String login(@ModelAttribute("monForm") UserForm monForm, @PathVariable("param1") String param1,
			Model model) {

		try {
			String email = monForm.getEmail();
			String password = monForm.getPassword().trim();

			User user = us.readByEmail(email);

			System.out.println(password);
			System.out.println(user.getPassword());

			if (user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "dashboard";
			} else {
				model.addAttribute("msg", "Votre mot de passe n'existe pas");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return "home";
	}

	// Les méthodes annotées avec @ModelAttribute sont automatiquement appelées par
	// Spring avant
	// qu'une requête arrive dans nos méthodes de la Servlet
	@ModelAttribute("monForm")
	public UserForm getUserForm() {
		// Quand on veut utiliser un bean, en utilisant ce genre de méthode il va
		// injecter dans le model
		// automatiquement le bean ( plus besoin de faire model.addAttribute("monBean",
		// new ExempleForm());)
		return new UserForm();
	}

}
