package tn.enicarthage.plateforme.services;

import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Departement;
import tn.enicarthage.plateforme.entities.Enseignant;

import java.util.List;
import java.util.Optional;

@Service
public interface IServiceDepartement {
    public void afecterEnseignantADepartement(Integer idEns , Integer idDep);
    public List<Departement> getDepartement();

    //public Optional<Paquet> getDepartementById(int id);
    public Departement addDepartement(Departement p);

    public void removeDepartement(int id);

    public Departement updateDepartement(Departement p);

    public Optional<Departement> getDepartementById(int id);

    public boolean existById(int id);
}
