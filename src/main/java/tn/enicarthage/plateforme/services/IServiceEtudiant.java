package tn.enicarthage.plateforme.services;

import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.entities.Paquet;

import java.util.List;
import java.util.Optional;
@Service
public interface IServiceEtudiant {
    public List<Etudiant> getEtudiant();

    //public Optional<Etudiant> getEtudiantById(int id);
    public Etudiant addEtudiant(Etudiant p);

    public void removeEtudiant(int id);

    public Etudiant updateEtudiant(Etudiant p);

    public Optional<Etudiant> getEtudiantById(int id);

    public boolean existById(int id);

}
