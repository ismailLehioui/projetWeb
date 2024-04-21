package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.CopieCP;

public interface IServiceCopie {

	int deposerDemandeDoubleCorrection(CopieCP idCopie);
	void corrigerCopie(CopieCP idCopie, float note);
	
}
