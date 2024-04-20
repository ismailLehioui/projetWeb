package tn.enicarthage.plateforme.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CopieCP implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idCop;
	private int idEtudiant;
	private int idMatiere;

}
