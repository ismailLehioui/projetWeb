package tn.enicarthage.plateforme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.entities.UserInfo;
import tn.enicarthage.plateforme.repositories.EtudiantRepository;
import tn.enicarthage.plateforme.repositories.UserInfoRepository;

@Service
public class ServiceEtudiant implements IServiceEtudiant {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		UserInfo user = userInfoRepository.findByName(etudiant.getName()).get();
		etudiant.setId(user.getId());
		return etudiantRepository.save(etudiant);
	}

}
package tn.enicarthage.plateforme.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.repositories.EtudiantRepository;
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ServiceEtudiant implements IServiceEtudiant{
    @Autowired
    private EtudiantRepository etudiantRepository ;


    @Override
    public List<Etudiant> getEtudiant(){
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant p){
        return etudiantRepository.saveAndFlush(p);
    }
    @Override
    public void removeEtudiant(int id){
        etudiantRepository.deleteById(id);
    }
    @Override
    public Etudiant updateEtudiant(Etudiant p){
        return p;
    }
    @Override
    public Optional<Etudiant> getEtudiantById(int id){
        return etudiantRepository.findById(id);
    }

    @Override
    public boolean existById(int id){
        return etudiantRepository.existsById(id);
    }

}
