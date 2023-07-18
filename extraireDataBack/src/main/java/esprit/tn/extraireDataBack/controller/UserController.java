package esprit.tn.extraireDataBack.controller;

import javax.annotation.PostConstruct;

import esprit.tn.extraireDataBack.entity.User;
import esprit.tn.extraireDataBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.iniRolesAndUser();
	}
	
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping({"/getUserByuserName/{userName}"})
	public User getUserByuserName(@PathVariable String userName) {
		return userService.getUserByuserName(userName);
	}
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "this accessible for admin ";
	}
	@GetMapping({"/forClient"})
	@PreAuthorize("hasRole('Client')")
	public String forClient() {
		return "this accessible for client ";
	}
	@GetMapping({"/forLivreur"})
	@PreAuthorize("hasRole('Livreur')")
	public String forLivreur() {
		return "this accessible for livreur ";
	}

}
