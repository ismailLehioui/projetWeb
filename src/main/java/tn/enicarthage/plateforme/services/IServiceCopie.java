package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;

import java.time.LocalDate;
import java.util.List;

public interface IServiceCopie {

	int deposerDemandeDoubleCorrection(CopieCP idCopie);
	void corrigerCopie(CopieCP idCopie, float note);
	List<Copie> getAllCopies();
	List<Copie> getCopiesByEtudiant(int id);
	List<Copie> findCopiesByEtudiantIdAndDateRange(int idEtudiant, LocalDate startDate, LocalDate endDate);
}
