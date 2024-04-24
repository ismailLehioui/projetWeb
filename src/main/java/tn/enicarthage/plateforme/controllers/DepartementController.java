package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Departement;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.DepartementRepository;
import tn.enicarthage.plateforme.services.IServiceDepartement;
import tn.enicarthage.plateforme.services.IServiceEnseignant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/departements")
public class DepartementController {
    @Autowired
    private IServiceDepartement serviceDepartement;
    @PutMapping("/affecter-enseignant/{idEns}/{idDep}")
    public void afecterEnseignantADepartement
            (@PathVariable("idEns") int idEns , @PathVariable("idDep") int  idDep){
        serviceDepartement.afecterEnseignantADepartement(idEns,idDep);
    }

    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartement() {
        return serviceDepartement.getDepartement();
    }

    @GetMapping("/get-departement-by-id/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable("id") int id) {
        Departement departement= serviceDepartement.getDepartementById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement with id " + id + " not found"));
        return ResponseEntity.ok(departement);
    }

    @PostMapping("/add-departement")
    public Departement addDepartement(@RequestBody Departement p) {
        return serviceDepartement.addDepartement(p);
    }

    @PutMapping("/update-departement/{id}")
    public ResponseEntity<?> updateDepartement(@RequestBody Departement departement, @PathVariable("id") Integer id) {
        if (serviceDepartement.existById(id)) {
            Departement departementToUpdate = serviceDepartement.getDepartementById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Departement with id " + id + " not found"));

            departementToUpdate.setIdDepartement(departement.getIdDepartement());
            departementToUpdate.setNomDepartement(departement.getNomDepartement());
            departementToUpdate.setEnseignant(departement.getEnseignant());

            return ResponseEntity.ok().body(departementToUpdate);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Paquet with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    private DepartementRepository departementRepository;
    @DeleteMapping("/delete-departement/{id}")
    public ResponseEntity<?> deleteDepartement(@PathVariable("id") int id) {

        Departement departement = serviceDepartement.getDepartementById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Departement not exist with id :" + id));
            departementRepository.delete(departement);
            Map<String, String> response = new HashMap<>();
            response.put("message","Departement avec id "+id+" supprimée avec succès .");
            return ResponseEntity.ok(response);

        /*if (serviceDepartement.existById(id)) {
            serviceDepartement.removeDepartement(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Departement with id " + id + " deleted successfully.");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Departement with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }*/
    }


    /* @GetMapping("/get-departement-by-id/{id}")
    public ResponseEntity<?> getDepartementWithEnseignantNamesById(@PathVariable("id") int id) {
        Optional<Departement> departementOptional = serviceDepartement.getDepartementById(id);
        if (departementOptional.isPresent()) {
            Departement departement = departementOptional.get();
            Set<Enseignant> enseignants = departement.getEnseignant();
            List<String> enseignantNames = enseignants.stream()
                .map(Enseignant::getNom)
                .collect(Collectors.toList());
            return ResponseEntity.ok().body(enseignantNames);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Departement with id " + id + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }*/
}
