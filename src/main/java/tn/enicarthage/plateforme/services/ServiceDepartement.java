package tn.enicarthage.plateforme.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import tn.enicarthage.plateforme.entities.Departement;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.repositories.DepartementRepository;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class ServiceDepartement implements IServiceDepartement{
    @Autowired
    private DepartementRepository departementRepository ;
    @Autowired
    private EnseignantRepository enseignantRepository;

    public ServiceDepartement(DepartementRepository departementRepository, EnseignantRepository enseignantRepository) {
        this.departementRepository = departementRepository;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public void afecterEnseignantADepartement(Integer idEns , Integer idDep){
        Departement dep=departementRepository.findById(idDep).get();
        Enseignant ens =enseignantRepository.findById(idEns).get();
        ens.setDepartement(dep);
        enseignantRepository.saveAndFlush(ens);
    }

    @Override
    public List<Departement> getDepartement(){
        return departementRepository.findAll();
    }
    @Override
    public Departement addDepartement(Departement p){
        return departementRepository.saveAndFlush(p);
    }
    @Override
    public void removeDepartement(int id){
        departementRepository.deleteById(id);
    }
    @Override
    public Departement updateDepartement(Departement p){
        return p;
    }
    @Override
    public Optional<Departement> getDepartementById(int id){
        return departementRepository.findById(id);
    }

    @Override
    public boolean existById(int id){
        return departementRepository.existsById(id);
    }

}
