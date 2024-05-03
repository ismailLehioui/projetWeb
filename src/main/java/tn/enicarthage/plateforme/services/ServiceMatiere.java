package tn.enicarthage.plateforme.services;

import org.springframework.stereotype.Service;
import tn.enicarthage.plateforme.entities.Enseignant;
import tn.enicarthage.plateforme.entities.Matiere;
import tn.enicarthage.plateforme.entities.Paquet;
import tn.enicarthage.plateforme.repositories.MatiereRepository;
import tn.enicarthage.plateforme.repositories.PaquetRepository;

import java.util.List;
import java.util.Optional;

@Service

public class ServiceMatiere implements IServiceMatiere{
    private MatiereRepository matiereRepository;
    private PaquetRepository paquetRepository;

    public ServiceMatiere(MatiereRepository matiereRepository, PaquetRepository paquetRepository) {
        this.matiereRepository = matiereRepository;
        this.paquetRepository = paquetRepository;
    }
    @Override
    public void afecterPaquetAMatiere(Integer idPack , Integer idMat){
        Matiere mat=matiereRepository.findById(idMat).get();
        Paquet paquet =paquetRepository.findById(idPack).get();
        paquet.setExamen(mat);
        paquetRepository.saveAndFlush(paquet);
    }
    @Override
    public List<Matiere> getMatiere(){
        return matiereRepository.findAll();
    }
    @Override
    public Matiere addMatiere(Matiere p){
        return matiereRepository.saveAndFlush(p);
    }
    @Override
    public void removeMatiere(int id){
        matiereRepository.deleteById(id);
    }
    @Override
    public Matiere updateMatiere(Matiere p){
        return p;
    }
    @Override
    public Optional<Matiere> getMatiereById(int id){
        return matiereRepository.findById(id);
    }

    @Override
    public boolean existById(int id){
        return matiereRepository.existsById(id);
    }



}
