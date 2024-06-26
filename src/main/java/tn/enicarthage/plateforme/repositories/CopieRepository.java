package tn.enicarthage.plateforme.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;

import java.time.LocalDate;
import java.util.List;

public interface CopieRepository extends CrudRepository<Copie, Integer> {
	
	Copie findByIdCopie(CopieCP idCopie);
	List<Copie> findAll();
	List<Copie> findByEtdIdUtilisateur(int idEtudiant);
	void deleteByIdCopie(CopieCP id_cop);

}
