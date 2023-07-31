package esprit.tn.extraireDataBack.service;

import esprit.tn.extraireDataBack.entity.Offre;
import esprit.tn.extraireDataBack.entity.OffreRequest;

import java.util.List;

public interface IServiceOffre {

    public List<Offre> retrieveAllOffres();
    public Offre retrieveOffre(Integer offreId);
    public Offre addOffre(OffreRequest offreText);
    public void removeOffre(Integer offreId);
    public Offre modifyOffre(Offre offre);
}
