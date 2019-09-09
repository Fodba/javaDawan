package fr.dawan.clientWs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projsoap.ws.Addition;
import fr.dawan.projsoap.ws.Calculette;
import fr.dawan.projsoap.ws.CalculetteService;

@Controller
@RequestMapping("/calculette")
public class CalculetteController {

	@GetMapping("/testsoap")
	public String testSoap(Model model) {
		model.addAttribute("addition-form", new Addition());

		return "Calculette";
	}

	@PostMapping("/addition")
	public String addition(@ModelAttribute("addition-form") Addition addForm, BindingResult br, Model model) {
		Calculette serv = new CalculetteService().getCalculettePort();
		
		int resultat = serv.addition(addForm.getA(), addForm.getB());
		model.addAttribute("msg", "Resultat = " + resultat);
		model.addAttribute("addition-form", addForm);
		return "Calculette";
	}
}
