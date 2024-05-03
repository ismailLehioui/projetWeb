package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.services.IServiceEnseignant;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {
	
	@Autowired
	IServiceEnseignant serviceEnseignant;
	
	@PostMapping("/add")
	public Enseignant addEnseignant(@RequestBody Enseignant enseignant) {
		
		return serviceEnseignant.addEnseignant(enseignant);
		
	}
	
	
}
