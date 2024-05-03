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
}
	@GetMapping("/Notes/{id}")
		public List<Copie> getCopiesByEtudiant(@PathVariable int id){
			return serviceCopie.getCopiesByEtudiant(id);
		}

	@GetMapping("/NotesByDate/{id}")
	public List<Copie> getCopiesByDate(@PathVariable int id , @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
									   @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
		return serviceCopie.findCopiesByEtudiantIdAndDateRange(id, startDate, endDate);
	}
	 private final IServiceCopie IServiceCopie;
	    @Autowired
	    public CopieController(IServiceCopie IServiceCopie,IServicePaquet IServicePaquet) {
	        this.IServiceCopie = IServiceCopie;
	    }

	    @PostMapping("/creer")
	    public Copie créerCopie(@RequestBody Copie copie) {
	        Copie createdCopie = IServiceCopie.créerCopie(copie);
	        return createdCopie;
	    }
	    @GetMapping("/toutes")
	    public List<Copie> getAllCopies() {
	        List<Copie> copies = IServiceCopie.getAllCopies();
	        return  copies;
	    }
	    @PostMapping("/{copieId}/verifier")
	    public Copie verifierCopie(@PathVariable CopieCP idCop,float note) {
	        Copie updatedCopie = IServiceCopie.verifierCopie(idCop,note);
	        return updatedCopie;
	    }
	    //  récupérer toutes les copies
	    @GetMapping("/paquet/{paquetId}")
	    public Optional<Copie> getCopiesForPaquet(@PathVariable int id_paquet) {
	        Optional<Copie> copies = IServiceCopie.getCopiesByPaquet(id_paquet);
	        return copies;
	    }

}

