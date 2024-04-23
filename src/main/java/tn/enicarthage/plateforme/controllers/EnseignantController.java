package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.services.IServiceEnseignant;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/enseignants")

public class EnseignantController {

    @Autowired
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
        return serviceEnseignant.getEnseignantById(id);
        //.orElseThrow(() -> new EntityNotFoundException("Paquet with id " + id + " not found"));
    }

    @PostMapping("/add-enseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant p) {
        return serviceEnseignant.addEnseignant(p);
    }

    @PutMapping("/update-enseignant/{id}")
    public ResponseEntity<?> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable("id") Integer id) {
        if (serviceEnseignant.existById(id)) {
            Enseignant enseignantToUpdate = serviceEnseignant.getEnseignantById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Enseignant with id " + id + " not found"));

            enseignantToUpdate.setIdUtilisateur(enseignant.getIdUtilisateur());
            enseignantToUpdate.setNom(enseignant.getNom());
            enseignantToUpdate.setPrenom(enseignant.getPrenom());
            enseignantToUpdate.setNumTel(enseignant.getNumTel());
            enseignantToUpdate.setEmail(enseignant.getEmail());
            enseignantToUpdate.setMotDePasse(enseignant.getMotDePasse());
            enseignantToUpdate.setRole(enseignant.getRole());
            enseignantToUpdate.setPaquets(enseignant.getPaquets());

            serviceEnseignant.addEnseignant(enseignantToUpdate);
            return ResponseEntity.ok().body(enseignantToUpdate);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Paquet with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("/delete-enseignant/{id}")
    public ResponseEntity<?> deleteEnseignant(@PathVariable("id") int id) {
        if (serviceEnseignant.existById(id)) {
            serviceEnseignant.removeEnseignant(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Enseignant with id " + id + " deleted successfully.");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Enseignant with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
