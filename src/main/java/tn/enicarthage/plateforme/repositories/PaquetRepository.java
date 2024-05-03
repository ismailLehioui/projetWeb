package tn.enicarthage.plateforme.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Matiere;
import tn.enicarthage.plateforme.entities.Paquet;
public interface PaquetRepository extends JpaRepository<Paquet,Integer> {

	List<Copie> findByIdPaquet(int id_paquet);
	//recuperer les paquet d'un enseingant bien determine
	List<Paquet> findByCorrecteurIdUtilisateur(int correcteurId);
	Optional<Paquet> getPaquetByIdPaquet(int idPaquet);
	Matiere getExamenByIdPaquet(int idPaquet);


}