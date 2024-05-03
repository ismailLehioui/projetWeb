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
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDepartement")
public class Enseignant implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String name;
	String email;
	long numtel;
	@Enumerated(EnumType.STRING)
	Role role;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "correcteur")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Paquet> paquets;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Departement departement;
}
