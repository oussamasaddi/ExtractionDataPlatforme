package esprit.tn.extraireDataBack.service;

import esprit.tn.extraireDataBack.entity.Offre;
import esprit.tn.extraireDataBack.entity.OffreRequest;
import esprit.tn.extraireDataBack.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceOffre implements IServiceOffre{

    private static String DJANGO_URL="http://127.0.0.1:8000/";
    @Autowired
    OffreRepository offreRepository ;

    @Override
    public List<Offre> retrieveAllOffres() {
        return (List<Offre>) offreRepository.findAll() ;
    }

    @Override
    public Offre retrieveOffre(Integer offreId) {
        return offreRepository.findById(offreId).get();
    }

    @Override
    public Offre addOffre(OffreRequest  offreRequest ) {
        String dataExtractionUrl = DJANGO_URL+ "extraireOffre";
        RestTemplate restTemplate = new RestTemplate();
        Offre offre = restTemplate.postForObject(dataExtractionUrl, offreRequest, Offre.class);

        return offreRepository.save(offre);
    }

    @Override
    public void removeOffre(Integer offreId) {
        offreRepository.deleteById(offreId);
    }

    @Override
    public Offre modifyOffre(Offre offre) {
        return offreRepository.save(offre);
    }
}
