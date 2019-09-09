package fr.dawan.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
public class UserControllers {

	@RequestMapping("")
	public String display(Model model) {

		model.addAttribute("msg", "Mon message est-il clair?");
		return "home";
	}
}
