package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDepartement")

public class Matiere implements Serializable   {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMatiere;
	String nomMatiere;
	@OneToMany(mappedBy = "mat")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Copie> etudiants ;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Salle> salles ;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Paquet> paquets;

}
