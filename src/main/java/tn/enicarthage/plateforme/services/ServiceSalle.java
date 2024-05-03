package tn.enicarthage.plateforme.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.repositories.SalleRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceSalle implements IServiceSalle{
    @Autowired
    private SalleRepository salleRepository ;


    @Override
    public List<Salle> getSalles(){
        return salleRepository.findAll();
    }
    /*@Override
    public Optional<Paquet> getPackById(int id){
        Paquet p=paquetRepository.findById(id);
        return p;
    }*/

    @Override
    public Salle addSalle(Salle s){
        return salleRepository.saveAndFlush(s);
    }
    @Override
    public void removeSalle(int id){
        salleRepository.deleteById(id);
    }
    @Override
    public Salle updateSalle(Salle s){
        return s;
    }
    @Override
    public Optional<Salle> getSalleById(int id){
        return salleRepository.findById(id);
    }
    @Override
    public boolean existById(int id){
        return salleRepository.existsById(id);
    }

}
