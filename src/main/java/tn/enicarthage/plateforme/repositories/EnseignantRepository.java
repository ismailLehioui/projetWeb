package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.enums.Role;

import java.util.List;
import java.util.Optional;
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
	Enseignant findByIdUtilisateur(int idUtilisateur);

	void deleteByIdUtilisateur(Long id);

	List<Enseignant> findByRole(Role role);


}
