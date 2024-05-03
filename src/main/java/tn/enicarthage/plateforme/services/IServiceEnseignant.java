package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.Enseignant;

public interface IServiceEnseignant {
	
	Enseignant addEnseignant(Enseignant enseignant);

}
package tn.enicarthage.plateforme.services;

import org.springframework.stereotype.Service;

import tn.enicarthage.plateforme.entities.CopieCP;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Paquet;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service

public interface IServiceEnseignant {
    public void afecterPaquetAuEnseignant(Integer idPack , Integer idEns);
    public List<Enseignant> getEnseignant();

    //public Optional<Paquet> getEnseignantById(int id);
    public Enseignant addEnseignant(Enseignant p);

    public void removeEnseignant(int id);

    public Enseignant updateEnseignant(Enseignant p);

    public Enseignant getEnseignantById(int id);

    public boolean existById(int id);
    void  corrigerCopie(CopieCP idCop, float note);

	Set<Paquet> getPaquetsAVerifier(int correcteurId);
	 List<Enseignant> getAllEnseignants();
	    void deleteEnseignant(Long id);

		Enseignant créerEnseignant(Enseignant enseignant);

}
