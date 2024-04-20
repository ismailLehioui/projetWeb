package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import tn.enicarthage.plateforme.enums.Role;

@Entity
@DiscriminatorValue("PROF")
public class Enseignant extends Utilisateur implements Serializable  {

	String email;
	String motDePasse;
	@Enumerated(EnumType.STRING)
	Role role;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "correcteur")
	Set<Paquet> paquets;
	
}
