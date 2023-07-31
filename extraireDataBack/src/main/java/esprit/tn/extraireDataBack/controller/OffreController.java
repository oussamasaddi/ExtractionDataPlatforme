package esprit.tn.extraireDataBack.controller;


import esprit.tn.extraireDataBack.entity.Offre;
import esprit.tn.extraireDataBack.entity.OffreRequest;
import esprit.tn.extraireDataBack.service.IServiceOffre;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
@Tag(name="Web Services - Offre")
public class OffreController {


    @Autowired
    IServiceOffre offreService;

    // http://localhost:8089/ski/Offre/retrieve-all-Offres
    @GetMapping("/retrieve-all-Offres")
    @Operation(description = "wiem tjib tous les Offres")
    public List<Offre> getOffres() {
        List<Offre> listOffres = offreService.retrieveAllOffres();
        return listOffres;
    }


    // http://localhost:8089/SpringMVC/Offre/retrieve-Offre/8
    @GetMapping("/retrieve-Offre/{Offre-id}")
    @Operation(description = "wiem tjib  un Offre")

    public Offre retrieveOffre(@PathVariable("Offre-id") Integer offreid) {
        Offre Offre = offreService.retrieveOffre(offreid);
        return Offre;
    }

    // http://localhost:8089/SpringMVC/Offre/add-Offre
    @PostMapping("/add-Offre")
    @Operation(description = "wiem tsajel un Offre")

    public Offre addOffre(@RequestBody OffreRequest p) {
        Offre Offre = offreService.addOffre(p);
        return Offre;
    }

    // http://localhost:8089/SpringMVC/Offre/remove-Offre/{Offre-id}
    @DeleteMapping("/remove-Offre/{Offre-id}")
    @Operation(description = "wiem tfassekh un Offre")

    public void removeOffre(@PathVariable("Offre-id") Integer proejtId) {
        offreService.removeOffre(proejtId);
    }

    // http://localhost:8089/SpringMVC/Offre/modify-Offre
    @PutMapping("/modify-Offre")
    @Operation(description = "wiem tbadel un  Offre")
    public Offre modifyOffre(@RequestBody Offre p) {
        Offre Offre = offreService.modifyOffre(p);
        return Offre;
    }
}
