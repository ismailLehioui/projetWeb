package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.services.IServiceEtudiant;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private IServiceEtudiant serviceEtudiant;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return serviceEtudiant.getEtudiant();
    }

    @GetMapping("/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable int id) {
        return serviceEtudiant.getEtudiantById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return serviceEtudiant.addEtudiant(etudiant);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEtudiant(@PathVariable int id) {
        serviceEtudiant.removeEtudiant(id);
    }
}
