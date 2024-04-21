package tn.enicarthage.plateforme.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;

public interface CopieRepository extends CrudRepository<Copie, Integer> {
	
	Copie findByIdCopie(CopieCP idCopie);

}
