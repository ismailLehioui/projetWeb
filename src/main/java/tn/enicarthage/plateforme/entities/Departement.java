package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import tn.enicarthage.plateforme.enums.Filiere;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDepartement")
public class Departement implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idDepartement;
	@Enumerated(EnumType.STRING)
	Filiere nomDepartement;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "departement")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	Set<Enseignant> enseignant ;

}
