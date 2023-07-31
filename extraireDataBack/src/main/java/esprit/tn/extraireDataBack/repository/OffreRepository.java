package esprit.tn.extraireDataBack.repository;

import esprit.tn.extraireDataBack.entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Integer> {
}
