package tn.enicarthage.plateforme.services;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Matiere;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public interface IServiceMatiere {
    public void afecterPaquetAMatiere(Integer idPack , Integer idMat);

    public List<Matiere> getMatiere();

    //public Optional<Paquet> getMatiereById(int id);
    public Matiere addMatiere(Matiere p);

    public void removeMatiere(int id);

    public Matiere updateMatiere(Matiere p);

    public boolean existById(int id);

	Set<Copie> getCopiesByIdMatiere(int idMatiere);
}
