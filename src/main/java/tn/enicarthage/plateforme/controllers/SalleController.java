package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.services.IServicePaquet;
import tn.enicarthage.plateforme.services.IServiceSalle;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/salles")
public class SalleController {

    @Autowired
    private IServiceSalle serviceSalle;

    @GetMapping("/retrieve-all-salles")
    public List<Salle> getPack(){
        return serviceSalle.getSalles();
    }

    @GetMapping("/get-salle-by-id/{id}")
    public Optional<Salle> getSallebyId(@PathVariable("id") int id){
        return serviceSalle.getSalleById(id);
    }

    @PostMapping("/add-salle")
    public Salle addPack(@RequestBody Salle s){
        Salle salle = serviceSalle.addSalle(s);
        return salle ;
    }

    @PutMapping("/update-salle/{id}")
    public ResponseEntity<?> updateSalle(@RequestBody Salle salle,@PathVariable("id") Integer id){

        if(serviceSalle.existById(id)){
            Salle salle1= serviceSalle.getSalleById(id).
                    orElseThrow
                            (
                                    ()->new EntityNotFoundException("requested salle not found")
                            );
            salle1.setNumSalle(salle.getNumSalle());
            salle1.setNbPlaces(salle.getNbPlaces());
            serviceSalle.addSalle(salle1);
            return ResponseEntity.ok().body(salle1);
        }else {
            HashMap<String,String> message= new HashMap<>();
            message.put("message","salle avec id "+id+" not found or matched .");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }


    @DeleteMapping("/delete-salle/{id}")
    public ResponseEntity<?> deleteSalle(@PathVariable("id") int id){

        if(serviceSalle.existById(id)){
            serviceSalle.removeSalle(id);
            HashMap<String,String> message= new HashMap<>();
            message.put("message","salle avec id "+id+" supprimée avec succès .");
            //retourner le type hashMap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }else {
            HashMap<String,String> message= new HashMap<>();
            message.put("message","salle avec id "+id+" not found or matched .");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
