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
    public Optional<Enseignant> getEnseignantById(@PathVariable("id") int id) {
        Optional<Enseignant> enseignant= serviceEnseignant.getEnseignantById(id);
        return enseignant;
    }

    @PostMapping("/add-enseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant p) {
        return serviceEnseignant.addEnseignant(p);
    }

    @PutMapping("/update-enseignant/{id}")
    /*public void updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable("id") Integer id) {
        if (serviceEnseignant.existById(id)) {
            Optional<Enseignant> enseignantToUpdate = serviceEnseignant.getEnseignantById(id);
              
            enseignantToUpdate.setIdUtilisateur(enseignant.getIdUtilisateur());
            enseignantToUpdate.setNom(enseignant.getNom());
            enseignantToUpdate.setPrenom(enseignant.getPrenom());
            enseignantToUpdate.setNumTel(enseignant.getNumTel());
            enseignantToUpdate.setEmail(enseignant.getEmail());
            enseignantToUpdate.setMotDePasse(enseignant.getMotDePasse());
            enseignantToUpdate.setRole(enseignant.getRole());
            enseignantToUpdate.setPaquets(enseignant.getPaquets());

            serviceEnseignant.addEnseignant(enseignantToUpdate);}
        
        }*/
    

    @DeleteMapping("/delete-enseignant/{id}")
    public void deleteEnseignant(@PathVariable("id") int id) {
        serviceEnseignant.getEnseignantById(id);
            serviceEnseignant.removeEnseignant(id);
    }

        /*if (serviceEnseignant.existById(id)) {
            serviceEnseignant.removeEnseignant(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Enseignant with id " + id + " deleted successfully.");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Enseignant with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }*/
    
    @PutMapping("/corriger-copie")
    public ResponseEntity<String> corrigerCopie(@RequestParam CopieCP id_cop, @RequestParam float note) {
    	serviceEnseignant.corrigerCopie(id_cop, note);
        return ResponseEntity.ok("Copie corrigée par l'enseignant");
    }
    @GetMapping("/verification")
    public List<Paquet> getPaquetsAVerifier(@RequestParam int correcteurId) {
        List<Paquet> paquets =serviceEnseignant.getPaquetsAVerifier(correcteurId);
        return paquets;
    }

    @GetMapping("/all")
    public List<Enseignant> getAllEnseignants() {
        return serviceEnseignant.getAllEnseignants();
    }

    @GetMapping("/{id}")
    public Optional<Enseignant> getEnseignantByIdUtilisateur(@PathVariable Long id) {
        return serviceEnseignant.getEnseignantByIdUtilisateur(id);
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


}
