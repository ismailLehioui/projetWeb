package tn.enicarthage.plateforme.services;
import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.enums.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import tn.enicarthage.plateforme.entities.Copie;
import tn.enicarthage.plateforme.entities.Matiere;

@Service

public interface IServicePaquet {
    public List<Paquet> getPack();
    public Paquet addPack(Paquet p);

    public void removePack(int id);

    public Paquet updatePack(Paquet p);

    public boolean existById(int id);

    public Paquet getPackByIdPaquet(int id);
    public Set<Copie> getCopieByIdPaquet(int id);
	List<Paquet> getPaquetByIdCorrecteur(int correcteurId);
	boolean VerifierProfPaquet(int idPaquet);
	boolean VerifierResponsablePaquet(int idPaquet);
	int getExamenByIdPaquet(int idPaquet);
	boolean CorrectionPaquet(int idPaquet);
	boolean VerifierFautePaquet(int idPaquet);

}