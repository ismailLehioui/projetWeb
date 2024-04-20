package tn.enicarthage.plateforme.services;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ServicePaquet implements IServicePaquet{

    @Autowired
    private PaquetRepository paquetRepository ;


    @Override
    public List<Paquet> getPack(){
        return paquetRepository.findAll();
    }
    @Override
    public Paquet addPack(Paquet p){
        return paquetRepository.saveAndFlush(p);
    }
    @Override
    public void removePack(int id){
        paquetRepository.deleteById(id);
    }
    @Override
    public Paquet updatePack(Paquet p){
        return p;
    }
    @Override
    public Optional<Paquet> getPackById(int id){
        return paquetRepository.findById(id);
    }

    @Override
    public boolean existById(int id){
        return paquetRepository.existsById(id);
    }


}
