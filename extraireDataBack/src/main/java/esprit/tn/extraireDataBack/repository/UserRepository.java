package esprit.tn.extraireDataBack.repository;

import esprit.tn.extraireDataBack.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
