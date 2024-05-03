package tn.enicarthage.plateforme.services;

import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Paquet;
import java.util.List;
import java.util.Optional;

import tn.enicarthage.plateforme.entities.Copie;

@Service

public interface IServicePaquet {
    public List<Paquet> getPack();

    //public Optional<Paquet> getPackById(int id);
    public Paquet addPack(Paquet p);

    public void removePack(int id);

    public Paquet updatePack(Paquet p);

    public Optional<Paquet> getPackById(int id);

    public boolean existById(int id);



    public Optional<Paquet> getPackByIdPaquet(int id);

   public Paquet getPaquetsAVerifier(int correcteurId);
    public Optional <Copie> getCopieByIdPaquet(int id);

}