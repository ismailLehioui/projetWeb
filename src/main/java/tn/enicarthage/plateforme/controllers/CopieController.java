package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.services.IServiceCopie;

@RestController
@RequestMapping("/api/copie")
public class CopieController {

	@Autowired
	IServiceCopie serviceCopie;
	
	@PostMapping("/deposer_demande")
	@ResponseBody
	public int deposerDemandeDoubleCorrection(@RequestBody CopieCP idCopie) {
		return serviceCopie.deposerDemandeDoubleCorrection(idCopie);
	}
	
}
