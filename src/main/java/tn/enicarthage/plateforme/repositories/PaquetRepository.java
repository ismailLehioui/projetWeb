package tn.enicarthage.plateforme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Paquet;
public interface PaquetRepository extends JpaRepository<Paquet,Integer> {

	Optional<Copie> findByIdPaquet(int id_paquet);
	  Paquet findByCorrecteurIdUtilisateur(int correcteurId);


}