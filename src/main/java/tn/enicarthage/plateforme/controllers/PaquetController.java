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
    public ResponseEntity<Paquet> getPaquetById(@PathVariable("id") int id) {
        Paquet paquet=servicePaquet.getPackById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paquet with id " + id + " not found"));
        return ResponseEntity.ok(paquet);
    }

    @PostMapping("/add-paquet")
    public Paquet addPaquet(@RequestBody Paquet p) {
        return servicePaquet.addPack(p);
    }

    @PutMapping("/update-paquet/{id}")
    public ResponseEntity<?> updatePaquet(@RequestBody Paquet paquet, @PathVariable("id") Integer id) {
        if (servicePaquet.existById(id)) {
            Paquet paquetToUpdate = servicePaquet.getPackById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Paquet with id " + id + " not found"));

            paquetToUpdate.setIdPaquet(paquet.getIdPaquet());
            paquetToUpdate.setSalle(paquet.getSalle());
            paquetToUpdate.setExamen(paquet.getExamen());
            paquetToUpdate.setCorrecteur(paquet.getCorrecteur());
            servicePaquet.addPack(paquetToUpdate);
            return ResponseEntity.ok().body(paquetToUpdate);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Paquet with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("/delete-paquet/{id}")
        public ResponseEntity<?> deletePaquet(@PathVariable("id") int id){

            servicePaquet.getPackById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Pack not exist with id :" + id));
            servicePaquet.removePack(id);
            Map<String, String> response = new HashMap<>();
            response.put("message","paquet avec id "+id+" supprimée avec succès .");
            return ResponseEntity.ok(response);

            /*
        if (servicePaquet.existById(id)) {
            servicePaquet.removePack(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Paquet with id " + id + " deleted successfully.");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Paquet with id " + id + " not found or matched.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }*/
    }
}
