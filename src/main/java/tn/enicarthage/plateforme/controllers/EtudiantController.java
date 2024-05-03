package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.plateforme.entities.Etudiant;
import tn.enicarthage.plateforme.services.IServiceEtudiant;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	IServiceEtudiant serviceEtudiant;
	
	@PostMapping("/add")
	public Etudiant add(@RequestBody Etudiant etudiant) {
		
		return serviceEtudiant.addEtudiant(etudiant);
		
	}

}
