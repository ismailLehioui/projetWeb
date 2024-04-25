package tn.enicarthage.plateforme.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.repositories.CopieRepository;
import tn.enicarthage.plateforme.repositories.EtudiantRepository;
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCopie implements IServiceCopie {
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public int deposerDemandeDoubleCorrection(CopieCP idCopie) {
		
		Copie copie = copieRepository.findByIdCopie(idCopie);
		if(copie!=null && !copie.getDemandeDoubleCorrection()) {
			Etudiant etudiant = etudiantRepository.findById(idCopie.getIdEtudiant()).get();
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
			copie.setNoteInitiale(note);
			copieRepository.save(copie);
		}
	}
	public List<Copie> getCopiesByEtudiant(int id){
		List<Copie> result = copieRepository.findByEtdIdUtilisateur(id);
		return result ;
	}
	public List<Copie> findCopiesByEtudiantIdAndDateRange(int idEtudiant, LocalDate startDate, LocalDate endDate) {
		return copieRepository.findByEtdIdUtilisateurAndDateCopieBetween(idEtudiant, startDate, endDate);
	}

	@Override
	public List<Copie> getCopiesForPaquet(int paquetId) {
		return copieRepository.findByPaquetId(paquetId);
}
	@Autowired
    private CopieRepository copieRepository;
    @Autowired
    private PaquetRepository paquetRepository;
    @Override
    public Copie créerCopie(Copie copie) {
        return copieRepository.save(copie);
    }

    @Override
    public List<Copie> getAllCopies() {
        return copieRepository.findAll();
    }

    @Override
    public Optional<Copie> getCopiesByPaquet(int id_paquet) {
        return paquetRepository.findByIdPaquet(id_paquet);
    }

    @Override
    public Copie verifierCopie(CopieCP idCop,float note) {
        Copie optionalCopie = copieRepository.findByIdCopie(idCop);
        optionalCopie.setNoteVerifProf(note);
        if(optionalCopie.getNoteInitiale()!=note)
        	optionalCopie.setFaute(true);
        else 
        	optionalCopie.setFaute(false);
        return optionalCopie;
        }
    
    
  
}
