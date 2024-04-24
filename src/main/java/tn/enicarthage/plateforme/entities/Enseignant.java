package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.enicarthage.plateforme.enums.Role;

@Entity
@Data
@DiscriminatorValue("PROF")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDepartement")
public class Enseignant extends Utilisateur implements Serializable  {

	String email;
	String motDePasse;
	@Enumerated(EnumType.STRING)
	Role role;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "correcteur")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Paquet> paquets;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Departement departement;
}
