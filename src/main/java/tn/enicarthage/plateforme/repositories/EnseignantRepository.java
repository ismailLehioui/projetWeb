package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.plateforme.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {

}
