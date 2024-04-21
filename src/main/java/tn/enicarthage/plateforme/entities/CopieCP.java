package tn.enicarthage.plateforme.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CopieCP implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idCop;
	private int idEtudiant;
	private int idMatiere;

}
