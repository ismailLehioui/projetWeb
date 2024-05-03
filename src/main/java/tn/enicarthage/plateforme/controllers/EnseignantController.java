package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;
import tn.enicarthage.plateforme.services.IServiceEnseignant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/enseignants")

public class EnseignantController {

    private IServiceEnseignant serviceEnseignant;

	@PutMapping("/affecter-paquet/{idPack}/{idEns}")
    public void afecterPaquetAuEnseignant
            (@PathVariable("idPack") int idPack , @PathVariable("idEns") int idEns){
        serviceEnseignant.afecterPaquetAuEnseignant(idPack,idEns);
    }

    @GetMapping("/retrieve-all-enseignant")
    public List<Enseignant> getEnseignant() {
        return serviceEnseignant.getEnseignant();
    }

    @GetMapping("/get-enseignant-by-id/{id}")
    public Enseignant getEnseignantById(@PathVariable("id") int id) {
        Enseignant enseignant= serviceEnseignant.getEnseignantById(id);
        return enseignant;
    }

    @PostMapping("/add-enseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant p) {
        return serviceEnseignant.addEnseignant(p);
    }


    @DeleteMapping("/delete-enseignant/{id}")
    public void deleteEnseignant(@PathVariable("id") int id) {
        serviceEnseignant.getEnseignantById(id);
            serviceEnseignant.removeEnseignant(id);
    }
    
    @PutMapping("/corriger-copie/")
    public void corrigerCopie(@RequestParam CopieCP id_cop, @RequestParam float note) {
    	serviceEnseignant.corrigerCopie(id_cop, note);
        
    }
  

    @GetMapping("/all")
    public List<Enseignant> getAllEnseignants() {
        return serviceEnseignant.getAllEnseignants();
    }

    @PostMapping("/creer")
    public Enseignant créerEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant createdEnseignant = serviceEnseignant.créerEnseignant(enseignant);
        return createdEnseignant;
    }

    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable Long id) {
    	serviceEnseignant.deleteEnseignant(id);
    }
    //les paquets a verifier par l'enseignant determine
    @GetMapping("/verification/{id}")
    public Set<Paquet> getPaquetsAVerifier(@PathVariable("id")int correcteurId) {
        Set<Paquet> paquets =serviceEnseignant.getPaquetsAVerifier(correcteurId);
        return paquets;
    }
    
  
}
