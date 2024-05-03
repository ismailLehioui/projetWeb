package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.plateforme.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

}
