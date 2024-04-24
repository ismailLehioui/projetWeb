package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;
import tn.enicarthage.plateforme.services.ServiceEtudiant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class EtutidantController {

    @Autowired
    private ServiceEtudiant serviceEtudiant;

    public EtutidantController(ServiceEtudiant serviceEtudiant) {
        this.serviceEtudiant = serviceEtudiant;
    }

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiant() {
        return serviceEtudiant.getEtudiant();
    }

    @GetMapping("/get-etudiant-by-id/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") int id) {
        Etudiant etudiant= serviceEtudiant.getEtudiantById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant with id " + id + " not found"));
        return ResponseEntity.ok(etudiant);
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant p) {
        return serviceEtudiant.addEtudiant(p);
    }

    @PutMapping("/update-etudiant/{id}")
    public ResponseEntity<?> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable("id") Integer id) {
        if (serviceEtudiant.existById(id)) {
            Etudiant etudiantToUpdate = serviceEtudiant.getEtudiantById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Enseignant with id " + id + " not found"));

            etudiantToUpdate.setIdUtilisateur(etudiant.getIdUtilisateur());
            etudiantToUpdate.setNom(etudiant.getNom());
            etudiantToUpdate.setPrenom(etudiant.getPrenom());
            etudiantToUpdate.setNumTel(etudiant.getNumTel());
            etudiantToUpdate.setNiveau(etudiant.getNiveau());
            etudiantToUpdate.setFiliere(etudiant.getFiliere());
            etudiantToUpdate.setNombreDemandes(etudiant.getNombreDemandes());
            etudiantToUpdate.setMatieres(etudiant.getMatieres());

            serviceEtudiant.addEtudiant(etudiantToUpdate);
            return ResponseEntity.ok().body(etudiantToUpdate);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Etudiant with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    private EnseignantRepository enseignantRepository;

    @DeleteMapping("/delete-enseignant/{id}")
    public ResponseEntity<?> deleteEnseignant(@PathVariable("id") int id) {
        serviceEtudiant.getEtudiantById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Et not exist with id :" + id));
        serviceEtudiant.removeEtudiant(id);
        Map<String, String> response = new HashMap<>();
        response.put("message","etudiant avec id "+id+" supprimée avec succès .");
        return ResponseEntity.ok(response);

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
    }
}
