package tn.enicarthage.plateforme.repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere,Integer> {

	Set<Copie> getEtudiantsByIdMatiere(int idMatiere);

}
