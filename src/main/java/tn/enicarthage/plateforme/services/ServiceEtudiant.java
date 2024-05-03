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
