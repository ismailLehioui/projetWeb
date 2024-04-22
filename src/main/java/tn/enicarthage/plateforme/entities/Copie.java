package tn.enicarthage.plateforme.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Copie implements Serializable   {

	private static final long serialVersionUID=1L;
	@EmbeddedId
	CopieCP idCopie;
	float note;
	Boolean demandeDoubleCorrection = false;
	@ManyToOne
	@JoinColumn(name = "idEtudiant" ,insertable = false,updatable = false)
	Etudiant etd;

	@ManyToOne
	@JoinColumn(name = "idEtudiant" ,insertable = false,updatable = false)
	Matiere mat;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateCopie;

}
