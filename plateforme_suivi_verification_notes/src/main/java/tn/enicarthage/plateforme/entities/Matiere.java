package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Matiere implements Serializable   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMatiere;
	String nomMatiere;
	@OneToMany(mappedBy = "mat")
	Set<Copie> etudiants ;
	@OneToMany(cascade = CascadeType.ALL)
	Set<Salle> salles ;
	
	
}
