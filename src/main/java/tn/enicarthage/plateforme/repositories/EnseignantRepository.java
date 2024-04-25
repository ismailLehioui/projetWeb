package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Paquet;

import java.util.List;
import java.util.Optional;
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
	List<Paquet> findByIdUtilisateur(int idUtilisateur);

	Optional<Enseignant> findByIdUtilisateur(Long id);

	void deleteByIdUtilisateur(Long id);


}
