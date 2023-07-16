package esprit.tn.extraireDataBack.repository;

import esprit.tn.extraireDataBack.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, String>{

}
