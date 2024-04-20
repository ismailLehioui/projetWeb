package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import tn.enicarthage.plateforme.enums.Filiere;

@Entity
@DiscriminatorValue("2")
public class Etudiant extends Utilisateur implements Serializable  {

	String classe;
	String niveau;
	@Enumerated(EnumType.STRING)
	Filiere filiere;
	@OneToMany(mappedBy = "etd")
	Set<Copie> matieres ;
	
}
