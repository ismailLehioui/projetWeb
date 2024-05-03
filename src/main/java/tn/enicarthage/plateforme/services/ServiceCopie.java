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
    //prendre la note de verif prof
   @Override 
   public float getNoteVerifProf(CopieCP idcopie)
   {
		  Copie cop=copieRepository.findByIdCopie(idcopie);
	   return cop.getNoteVerifProf();
	   
   }
   //prendre la note de verif resp
   @Override 
   public float getNoteVerifResp(CopieCP idcopie)
   {
		  Copie cop=copieRepository.findByIdCopie(idcopie);
	   return cop.getNoteVerifResp();
	   
   }
   //prendre la note initiale
   @Override 
   public float getNoteInitiale(CopieCP idcopie)
   {
		  Copie cop=copieRepository.findByIdCopie(idcopie);
	   return cop.getNoteInitiale();
	   
   }
   
   //mettre la note de verif prof
  @Override 
  public void setNoteVerifProf(CopieCP idcopie,float verif)
  {
	  Copie cop=copieRepository.findByIdCopie(idcopie);
	    cop.setVerifP(true);
	    cop.setNoteVerifProf(verif);
	   
  }
 
   //mettre la note de verif responsable
 @Override 
 public void setNoteVerifResp(CopieCP idcopie,float verif)
 {
	  Copie cop=copieRepository.findByIdCopie(idcopie);
	    cop.setVerifR(true);
	    cop.setNoteVerifResp(verif);
	   
 }
 //mettre la note initiale
@Override 
public void setNoteInitiale(CopieCP idcopie,float verif)
{
	  Copie cop=copieRepository.findByIdCopie(idcopie);
	  cop.setNotI(true);
	    cop.setNoteInitiale(verif);
	   
}

   //calculer la faute  
   @Override
   public void setFaute(CopieCP idcopie)
   {
		  Copie cop=copieRepository.findByIdCopie(idcopie);

	  boolean f=(this.getNoteInitiale(idcopie)==this.getNoteVerifProf(idcopie));
     if(f==true)
     {
    	 f=this.getNoteInitiale(idcopie)==this.getNoteVerifResp(idcopie);
    	 
     }
     cop.setFaute(f);
	   
   }
   //retourne la faute
   @Override
   public boolean getFaute(CopieCP idcopie)
   {
		  Copie cop=copieRepository.findByIdCopie(idcopie);
		  return cop.isFaute();

	   
   }
  
}
