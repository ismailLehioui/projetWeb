package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Paquet implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idPaquet;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Enseignant correcteur;
	@OneToOne
	Salle salle;
	//Set<Enseignant> surveillant;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Matiere examen;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateCopie;
}
