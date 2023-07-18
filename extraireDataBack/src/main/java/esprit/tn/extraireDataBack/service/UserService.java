package esprit.tn.extraireDataBack.service;

import java.util.HashSet;
import java.util.Set;

import esprit.tn.extraireDataBack.entity.Role;
import esprit.tn.extraireDataBack.entity.User;
import esprit.tn.extraireDataBack.repository.RoleRepository;
import esprit.tn.extraireDataBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private PasswordEncoder passwordEncoder ;
	
	@Autowired
	private RoleRepository roleRepository;

	public User registerNewUser(User user) {
		
		Role role = roleRepository.findById("Client").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setUserPassword(getEncoderPassword(user.getUserPassword()));
		return userRepository.save(user);
	}
	
	public void iniRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleRepository.save(adminRole);
		
		Role clientRole = new Role();
		clientRole.setRoleName("Client");
		clientRole.setRoleDescription("Client Role");
		roleRepository.save(clientRole);
		
		Role livreurRole = new Role();
		livreurRole.setRoleName("Livreur");
		livreurRole.setRoleDescription("Livreur Role");
		roleRepository.save(livreurRole);
		
		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncoderPassword("admin@pass"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepository.save(adminUser);
		/**
		User clientUser = new User();
		clientUser.setUserFirstName("oussama");
		clientUser.setUserLastName("saddi");
		clientUser.setUserName("oussama123");
		clientUser.setUserPassword(getEncoderPassword("oussama@pass")); 
		Set<Role> clientRoles = new HashSet<>();
		clientRoles.add(clientRole);
		clientUser.setRole(clientRoles);
		userRepository.save(clientUser);
		
		User livreurUser = new User();
		livreurUser.setUserFirstName("ahmed");
		livreurUser.setUserLastName("bhd");
		livreurUser.setUserName("ahmed123");
		livreurUser.setUserPassword(getEncoderPassword("ahmed@pass"));
		Set<Role> livreurRoles = new HashSet<>();
		livreurRoles.add(livreurRole);
		livreurUser.setRole(livreurRoles);
		userRepository.save(livreurUser);
		**/
		
	}
	public String getEncoderPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public User getUserByuserName(String userName){ return  userRepository.findById(userName).get();}
}
