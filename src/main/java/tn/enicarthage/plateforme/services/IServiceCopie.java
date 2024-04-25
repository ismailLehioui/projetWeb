package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IServiceCopie {

	int deposerDemandeDoubleCorrection(CopieCP idCopie);
	void corrigerCopie(CopieCP idCopie, float note);
	List<Copie> getAllCopies();
	List<Copie> getCopiesByEtudiant(int id);
	List<Copie> findCopiesByEtudiantIdAndDateRange(int idEtudiant, LocalDate startDate, LocalDate endDate);
    List<Copie> getCopiesForPaquet(int paquetId);
    Copie créerCopie(Copie copie);
	Copie verifierCopie(CopieCP id_cop,float note);
	Optional<Copie> getCopiesByPaquet(int id_paquet);
	


}
