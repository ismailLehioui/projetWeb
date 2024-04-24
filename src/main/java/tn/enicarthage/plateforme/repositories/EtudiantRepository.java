package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.plateforme.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
