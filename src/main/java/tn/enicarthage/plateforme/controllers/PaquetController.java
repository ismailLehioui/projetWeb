package tn.enicarthage.plateforme.controllers;
import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.PaquetRepository;
import tn.enicarthage.plateforme.services.IServicePaquet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/packs")
public class PaquetController {
    @Autowired
    private IServicePaquet servicePaquet;

    @GetMapping("/retrieve-all-paquets")
    public List<Paquet> getPack() {
        return servicePaquet.getPack();
    }

    @GetMapping("/get-pack-by-id/{id}")
    public Paquet getPaquetById(@PathVariable Integer id) {
        return servicePaquet.getPackByIdPaquet(id);
    }

    @PostMapping("/add-paquet")
    public Paquet addPaquet(@RequestBody Paquet p) {
        return servicePaquet.addPack(p);
    }
    @GetMapping("/paquetEnseignant/{correcteurId}")
	public List<Paquet>getPaquetByIdCorrecteur(@PathVariable Integer correcteurId)
	{
    	List<Paquet> paquets=servicePaquet.getPaquetByIdCorrecteur(correcteurId);
    	return paquets;
    	
	}
    
    //verifierfautepaquet
    @GetMapping("/faute/verifier/{idPaquet}")
    public boolean verifierFautePaquet(@PathVariable("idPaquet") int idPaquet) {
        return servicePaquet.VerifierFautePaquet(idPaquet);
    }
  //verifier responsableDespaquets
    @GetMapping("/responsable/verifier/{idPaquet}")
    public boolean verifierResponsablePaquet(@PathVariable("idPaquet") int idPaquet) {
        return servicePaquet.VerifierResponsablePaquet(idPaquet);
    }
    
    
  //verifier ProfDespaquets
    @GetMapping("/prof/verifier/{idPaquet}")
    public boolean verifierProfPaquet(@PathVariable("idPaquet") int idPaquet) {
        return servicePaquet.VerifierProfPaquet(idPaquet);
    }
    //correction paquet
    @GetMapping("/paquet/correction/{idPaquet}")
    public boolean CorrectionPaquet(@PathVariable("idPaquet") int idPaquet) {
        return servicePaquet.CorrectionPaquet(idPaquet);
    }
    // la liste des copies d'un paquet
    @GetMapping("/paquet/copies/{idPaquet}")
    public Set<Copie> getCopiesByIdPaquet(@PathVariable("idPaquet") int idPaquet) {
        return servicePaquet.getCopieByIdPaquet(idPaquet);
    }
	}

