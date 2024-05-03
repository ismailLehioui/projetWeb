package tn.enicarthage.plateforme.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.exceptions.ResourceNotFoundException;
import tn.enicarthage.plateforme.repositories.SalleRepository;
import tn.enicarthage.plateforme.services.IServiceSalle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Salle> getSallebyId(@PathVariable("id") int id){
        // sans exception
        /*public Optional<Salle> getSallebyId(@PathVariable("id") int id){
        //return serviceSalle.getSalleById(id);}*/
        Salle salle= serviceSalle.getSalleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not exist with id :" + id));
        return ResponseEntity.ok(salle);
    }

    @PostMapping("/add-salle")
    public Salle addPack(@RequestBody Salle s){
        Salle salle = serviceSalle.addSalle(s);
        return salle ;
    }

    @PutMapping("/update-salle/{id}")
    public ResponseEntity<?> updateSalle(@RequestBody Salle salle,@PathVariable("id") Integer id){

            Salle salleToUpdate= serviceSalle.getSalleById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salle not exist with id :" + id));

            salleToUpdate.setNumSalle(salle.getNumSalle());
            salleToUpdate.setNbPlaces(salle.getNbPlaces());
            serviceSalle.addSalle(salleToUpdate);
            return ResponseEntity.ok().body(salleToUpdate);
    }



    @DeleteMapping("/delete-salle/{id}")
    public ResponseEntity<?> deleteSalle(@PathVariable("id") int id){

        serviceSalle.getSalleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not exist with id :" + id));
        serviceSalle.removeSalle(id);
        Map<String, String> response = new HashMap<>();
        response.put("message","salle avec id "+id+" supprimée avec succès .");
        return ResponseEntity.ok(response);

        /*     sans exception

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
        }*/
    }
}
