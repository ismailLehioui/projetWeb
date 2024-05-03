package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Etudiant implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String name;
	String classe;
	@Enumerated(EnumType.STRING)
	Niveau niveau;
	int nombreDemandes = 3;
	@Enumerated(EnumType.STRING)
	Filiere filiere;
	@OneToMany(mappedBy = "etd")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Copie> matieres ;
	
}
