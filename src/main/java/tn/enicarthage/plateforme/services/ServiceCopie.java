package tn.enicarthage.plateforme.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.repositories.CopieRepository;
import tn.enicarthage.plateforme.repositories.EtudiantRepository;

@Service
public class ServiceCopie implements IServiceCopie {
	
	@Autowired
	CopieRepository copieRepository;
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public int deposerDemandeDoubleCorrection(CopieCP idCopie) {
		
		Copie copie = copieRepository.findByIdCopie(idCopie);
		if(copie!=null && !copie.getDemandeDoubleCorrection()) {
			Etudiant etudiant = etudiantRepository.findById((int) idCopie.getIdEtudiant()).get();
			if(etudiant!=null) {
				if(etudiant.getNombreDemandes()>0) {
					copie.setDemandeDoubleCorrection(true);
					etudiant.setNombreDemandes(etudiant.getNombreDemandes()-1);
					copieRepository.save(copie);
					etudiantRepository.save(etudiant);
					return 0;
				} else {
					return -1;
				}
			} else return -2;
			
		} else {
			return -3;
		}
		
	}

	@Override
	public void corrigerCopie(CopieCP idCopie, float note) {
		
		Copie copie = copieRepository.findByIdCopie(idCopie);
		if(copie!=null) {
			copie.setNote(note);
			copieRepository.save(copie);
		}
		
	}

}
