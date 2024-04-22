package tn.enicarthage.plateforme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.services.IServiceCopie;

import java.time.LocalDate;
import java.util.List;

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
	@GetMapping("/getAllCopies")
	public List<Copie> getAllCopies() {
		return serviceCopie.getAllCopies();
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
}

