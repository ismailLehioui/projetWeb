package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.services.IServiceCopie;
import tn.enicarthage.plateforme.services.IServicePaquet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	
	@PostMapping("/corriger_copie/{nouvelleNote}")
	public void corrigerCopie(@RequestBody CopieCP copieId, @PathVariable float nouvelleNote) {
		serviceCopie.corrigerCopie(copieId, nouvelleNote);
	}
	@GetMapping("/Notes/{id}")
		public List<Copie> getCopiesByEtudiant(@PathVariable Integer id){
			return serviceCopie.getCopiesByEtudiant(id);
		}

	    @PostMapping("/creer")
	    public Copie créerCopie(@RequestBody Copie copie) {
	        Copie createdCopie = serviceCopie.créerCopie(copie);
	        return createdCopie;
	    }
	    @GetMapping("/toutes")
	    public List<Copie> getAllCopies() {
	        List<Copie> copies = serviceCopie.getAllCopies();
	        return  copies;
	    }
	    @PostMapping("/{copieId}/verifier")
	    public void verifierCopie(@PathVariable CopieCP idCop,float note) {
	        serviceCopie.corrigerCopie(idCop,note);
	        
	    }
	    //recuperer la note verif prof
	    @GetMapping("/note/verifProf/{idcopie}")
	    public float getNoteVerifProf(@PathVariable("idcopie") CopieCP idcopie) {
	        return serviceCopie.getNoteVerifProf(idcopie);
	    }
        //recuperer la note verif resp
	    @GetMapping("/note/verifResp/{idcopie}")
	    public float getNoteVerifResp(@PathVariable("idcopie") CopieCP idcopie) {
	        return serviceCopie.getNoteVerifResp(idcopie);
	    }
	    //recuperer la note initiale
	    @GetMapping("/note/initiale/{idcopie}")
	    public float getNoteInitiale(@PathVariable("idcopie") CopieCP idcopie) {
	        return serviceCopie.getNoteInitiale(idcopie);
	    }
	    //saisir la note verif prof
	    @PostMapping("/note/verifProf/{idcopie}")
	    public void setNoteVerifProf(@PathVariable("idcopie") CopieCP idcopie, @RequestParam("verif") float verif) {
	        serviceCopie.setNoteVerifProf(idcopie, verif);
	    }
	    //saisir la note verif respo
	    @PostMapping("/note/verifResp/{idcopie}")
	    public void setNoteVerifResp(@PathVariable("idcopie") CopieCP idcopie, @RequestParam("verif") float verif) {
	       u serviceCopie.setNoteVerifResp(idcopie, verif);
	    }
	    //saisir la note initiale
	    @PostMapping("/note/initiale/{idcopie}")
	    public void setNoteInitiale(@PathVariable("idcopie") CopieCP idcopie, @RequestParam("verif") float verif) {
	        serviceCopie.setNoteInitiale(idcopie, verif);
	    }
	    //saisir la faute automatiquement
	    @PostMapping("/faute/{idcopie}")
	    public void setFaute(@PathVariable("idcopie") CopieCP idcopie) {
	        serviceCopie.setFaute(idcopie);
	    }
	    //retourner la faute d'une copie
	    @GetMapping("/faute/{idcopie}")
	    public boolean getFaute(@PathVariable("idcopie") CopieCP idcopie) {
	    	this.setFaute(idcopie);
	        return serviceCopie.getFaute(idcopie);
	    }

}

