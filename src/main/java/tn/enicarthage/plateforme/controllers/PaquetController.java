package tn.enicarthage.plateforme.controllers;




import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.PaquetRepository;
import tn.enicarthage.plateforme.services.IServicePaquet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<Paquet> getPaquetById(@PathVariable("id") int id) {
        return servicePaquet.getPackByIdPaquet(id);
    }

    @PostMapping("/add-paquet")
    public Paquet addPaquet(@RequestBody Paquet p) {
        return servicePaquet.addPack(p);
    }

    /*@PutMapping("/update-paquet/{id}")
    public void updatePaquet(@RequestBody Paquet paquet, @PathVariable("id") Integer id) {
        if (servicePaquet.existById(id)) {
            Optional<Paquet> paquetToUpdate = servicePaquet.getPackByIdPaquet(id);

            paquetToUpdate.setIdPaquet(paquet.getIdPaquet());
            paquetToUpdate.setSalle(paquet.getSalle());
            paquetToUpdate.setExamen(paquet.getExamen());
            paquetToUpdate.setCorrecteur(paquet.getCorrecteur());
            servicePaquet.addPack(paquetToUpdate);

        } 
        }*/
    

    @DeleteMapping("/delete-paquet/{id}")
    public void deletePaquet(@PathVariable("id") int id) {
        if (servicePaquet.existById(id)) {
            servicePaquet.removePack(id);
        } 
    }

    @GetMapping("/a-verifier/{correcteurId}")
    public Paquet getPaquetsAVerifier(@RequestParam int correcteurId) {
        Paquet paquets = servicePaquet.getPaquetsAVerifier(correcteurId);
        return paquets;
    }

}
