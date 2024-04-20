package tn.enicarthage.plateforme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicarthage.plateforme.entities.Paquet;

public interface PaquetRepository extends JpaRepository<Paquet,Integer> {

}