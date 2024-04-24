package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Matiere;
import tn.enicarthage.plateforme.services.IServiceEnseignant;
import tn.enicarthage.plateforme.services.IServiceMatiere;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/matieres")

public class MatiereController {
    @Autowired
    private IServiceMatiere serviceMatiere;

    @PutMapping("/affecter-paquet/{idPack}/{idMat}")
    public void afecterPaquetAMatiere
            (@PathVariable("idPack") int idPack , @PathVariable("idMat") int idMat){
        serviceMatiere.afecterPaquetAMatiere(idPack,idMat);
    }

    @GetMapping("/retrieve-all-matiere")
    public List<Matiere> getMatiere() {
        return serviceMatiere.getMatiere();
    }

    @GetMapping("/get-matiere-by-id/{id}")
    public Optional<Matiere> getMatiereById(@PathVariable("id") int id) {
        return serviceMatiere.getMatiereById(id);
        //.orElseThrow(() -> new EntityNotFoundException("Paquet with id " + id + " not found"));
    }

    @PostMapping("/add-matiere")
    public Matiere addMatiere(@RequestBody Matiere p) {
        return serviceMatiere.addMatiere(p);
    }

    @PutMapping("/update-matiere/{id}")
    public ResponseEntity<?> updateMatiere(@RequestBody Matiere matiere, @PathVariable("id") Integer id) {
        if (serviceMatiere.existById(id)) {
            Matiere matiereToUpdate = serviceMatiere.getMatiereById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Matiere with id " + id + " not found"));

            matiereToUpdate.setIdMatiere(matiere.getIdMatiere());
            matiereToUpdate.setNomMatiere(matiere.getNomMatiere());
            matiereToUpdate.setSalles(matiere.getSalles());
            matiereToUpdate.setEtudiants(matiere.getEtudiants());
            matiereToUpdate.setPaquets(matiere.getPaquets());


            serviceMatiere.addMatiere(matiereToUpdate);
            return ResponseEntity.ok().body(matiereToUpdate);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "matiere with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("/delete-matiere/{id}")
    public ResponseEntity<?> deleteMatiere(@PathVariable("id") int id) {
        if (serviceMatiere.existById(id)) {
            serviceMatiere.removeMatiere(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Matiere with id " + id + " deleted successfully.");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Matiere with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
