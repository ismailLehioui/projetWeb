package tn.enicarthage.plateforme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.UserInfo;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;
import tn.enicarthage.plateforme.repositories.UserInfoRepository;

@Service
public class ServiceEnseignant implements IServiceEnseignant {
	
	@Autowired
	EnseignantRepository enseignantRepository;
	@Autowired
	UserInfoRepository userInfoRepository;
	
	
	@Override
	public Enseignant addEnseignant(Enseignant enseignant) {
		UserInfo user = userInfoRepository.findByName(enseignant.getName()).get();
		enseignant.setId(user.getId());
		return enseignantRepository.save(enseignant);
	}

}
