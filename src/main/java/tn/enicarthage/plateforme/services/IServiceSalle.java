package tn.enicarthage.plateforme.services;

import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.entities.Salle;

import java.util.List;
import java.util.Optional;

public interface IServiceSalle {
    public List<Salle> getSalles() ;
    //public Optional<Salle> getSalleById(int id);
    public Salle addSalle(Salle p);
    public void removeSalle(int id);
    public Salle updateSalle(Salle s);
    public boolean existById(int id);
    public Optional<Salle> getSalleById(int id);
}
