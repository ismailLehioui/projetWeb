package tn.enicarthage.plateforme.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Departement;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.repositories.CopieRepository;
import tn.enicarthage.plateforme.repositories.EnseignantRepository;
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor

public class ServiceEnseignant implements IServiceEnseignant{
    @Autowired
    private PaquetRepository paquetRepository;

    public ServiceEnseignant(EnseignantRepository enseignantRepository, PaquetRepository paquetRepository) {
        this.copieRepository = null;
		this.enseignantRepository = enseignantRepository;
        this.paquetRepository = paquetRepository;
    }

    @Override
    public void afecterPaquetAuEnseignant(Integer idPack , Integer idEns){
        Enseignant ens=enseignantRepository.findById(idEns).get();
        Paquet paquet =paquetRepository.findById(idPack).get();
        paquet.setCorrecteur(ens);
        paquetRepository.saveAndFlush(paquet);
    }
    @Override
    public List<Enseignant> getEnseignant(){
        return enseignantRepository.findAll();
    }
    @Override
    public Enseignant addEnseignant(Enseignant p){
        return enseignantRepository.saveAndFlush(p);
    }
    @Override
    public void removeEnseignant(int id){
        enseignantRepository.deleteById(id);
    }
    @Override
    public Enseignant updateEnseignant(Enseignant p){
        return p;
    }
    @Override
    public Optional<Enseignant> getEnseignantById(int id){
        return enseignantRepository.findById(id);
    }

    @Override
    public boolean existById(int id){
        return enseignantRepository.existsById(id);
    }
    private final CopieRepository copieRepository;
    private final EnseignantRepository enseignantRepository;
    @Override
    public void corrigerCopie(CopieCP id_cop, float note) {
        Copie copie = copieRepository.findByIdCopie(id_cop);
                
        copie.setNoteInitiale(note);

        copieRepository.save(copie);
    }
    @Override
    public List<Paquet> getPaquetsAVerifier(int correcteurId) {
        // Récupérer les paquets à vérifier par l'enseignant correcteur en fonction de son identifiant
        return enseignantRepository.findByIdUtilisateur(correcteurId);
    }
    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Optional<Enseignant> getEnseignantByIdUtilisateur(Long id) {
        return enseignantRepository.findByIdUtilisateur(id);
    }

  

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteByIdUtilisateur(id);
    }
	@Override
	public Enseignant créerEnseignant(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);
	}




}
