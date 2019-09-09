package fr.dawan.spring.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.spring.entities.User;
import fr.dawan.spring.service.UserService;

@RestController
@RequestMapping("/exemplews")
public class ExempleWS {

	@Autowired
	private UserService userService;
	
	@GetMapping(value= "/getusers", produces="application/json")
	public List<User> getAllUsers() {
		return userService.readAll();
	}
	
	@GetMapping(value= "/getusersxml", produces="application/xml")
	public User getAllUsersXml() {
		return userService.readById(1);
	}
	
	@PostMapping(value= "/insertUser", consumes="application/json")
	public void getAllUsers(@RequestBody List<User> users) {
		
		for(User user : users) {
			user.setId(0);
			user.setVersion(0);
			userService.create(user);
		}
	}
	
}
