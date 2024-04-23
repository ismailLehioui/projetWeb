package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.enicarthage.plateforme.enums.Filiere;
import tn.enicarthage.plateforme.enums.Niveau;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@DiscriminatorValue("ETDT")
public class Etudiant extends Utilisateur implements Serializable  {

	String classe;
	@Enumerated(EnumType.STRING)
	Niveau niveau;
	int nombreDemandes = 3;
	@Enumerated(EnumType.STRING)
	Filiere filiere;
	@OneToMany(mappedBy = "etd")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Copie> matieres ;
	
}
