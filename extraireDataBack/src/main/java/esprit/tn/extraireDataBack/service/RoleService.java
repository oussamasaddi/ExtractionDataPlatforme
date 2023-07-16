package esprit.tn.extraireDataBack.service;

import esprit.tn.extraireDataBack.entity.Role;
import esprit.tn.extraireDataBack.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}
}
