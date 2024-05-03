package tn.enicarthage.plateforme.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Matiere;
import tn.enicarthage.plateforme.entities.Paquet;
<<<<<<< HEAD
import tn.enicarthage.plateforme.entities.Salle;
import tn.enicarthage.plateforme.enums.Role;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;
import tn.enicarthage.plateforme.repositories.MatiereRepository;
=======
>>>>>>> 53feeb44bfeec36130bebfc48d706dce379a1633
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
@AllArgsConstructor

public class ServicePaquet implements IServicePaquet{

    @Autowired
    private PaquetRepository paquetRepository ;
    @Autowired
    private MatiereRepository matiereRepository ;
    @Autowired
    private EnseignantRepository enseignantRepository ;
    @Override
    public List<Paquet> getPack(){
        return paquetRepository.findAll();
    }
    @Override
    public Paquet addPack(Paquet p){
        return paquetRepository.saveAndFlush(p);
    }
    @Override
    public void removePack(int id){
        paquetRepository.deleteById(id);
    }
    @Override
    public Paquet updatePack(Paquet p){
        return p;
    }


    @Override
    public boolean existById(int id){
        return paquetRepository.existsById(id);
    }

    @Override
    public Paquet getPackByIdPaquet(int id){
        return paquetRepository.getReferenceById(id);
    }
    //retourner l'Id examen d'un paquet donnée
    @Override
    public int getExamenByIdPaquet(int idPaquet)
    {
    	Matiere exm =paquetRepository.getExamenByIdPaquet(idPaquet);
    	return exm.getIdMatiere();    	
    	
    }
    //retourner la liste des copies d'un paquet
    @Override
	public Set<Copie> getCopieByIdPaquet(int id) {
		int idExm=this.getExamenByIdPaquet(id);
		return matiereRepository.getEtudiantsByIdMatiere(id);
	}
    //correction paquet
    @Override
    public boolean CorrectionPaquet(int idPaquet)
    {
    	Set<Copie> copies=this.getCopieByIdPaquet(idPaquet);
    	for(Copie copie : copies)
    	{
    		if(copie.isNotI()==false)return false;
    	}
    	return true;
    }
	//retourner la liste des paquets d'un correcteur bien defini
	@Override
	public List<Paquet>getPaquetByIdCorrecteur(int correcteurId) {
	return paquetRepository.findByCorrecteurIdUtilisateur(correcteurId);
	
	}
	//verifierProfesseurDespaquets
	@Override
	public boolean VerifierProfPaquet(int idPaquet)
	{  
		Set<Copie> copies=this.getCopieByIdPaquet(idPaquet);
		for(Copie copie : copies)
		{
		    if (copie.isVerifP()==false)
		    {
		    return false;
		    
		    }
		}
		return true;
	}
	//verifierresponsableDespaquets
	@Override
	public boolean VerifierResponsablePaquet(int idPaquet)
	{
		Set<Copie> copies=this.getCopieByIdPaquet(idPaquet);
		for(Copie copie : copies)
		{
		    if (copie.isVerifR()==false)
		    {
		    return false;
		    
		    }
		}
		return true;
	}

	//Marquer faute profe
		@Override
		public boolean VerifierFautePaquet(int idPaquet)
		{
			Set<Copie> copies=this.getCopieByIdPaquet(idPaquet);
			for(Copie copie : copies)
			{
			    if (copie.isFaute()==false)
			    {
			    return false;
			    
			    }
			}
			return true;
		}
	
}
