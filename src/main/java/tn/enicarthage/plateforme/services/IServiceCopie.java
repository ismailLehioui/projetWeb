package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IServiceCopie {

	int deposerDemandeDoubleCorrection(CopieCP idCopie);
	List<Copie> getAllCopies();
	List<Copie> getCopiesByEtudiant(int id);
    Copie créerCopie(Copie copie);
	float getNoteVerifResp(CopieCP idcopie);
	float getNoteInitiale(CopieCP idcopie);
	float getNoteVerifProf(CopieCP idcopie);
	void setNoteVerifProf(CopieCP idcopie, float verif);
	void setNoteVerifResp(CopieCP idcopie, float verif);
	void setNoteInitiale(CopieCP idcopie,float note);
	void setFaute(CopieCP idcopie);
	void corrigerCopie(CopieCP idCopie, float note);
	boolean getFaute(CopieCP idcopie);
	
	


}
