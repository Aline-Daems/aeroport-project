package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.InterventionService;
import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.dal.models.Intervention;
import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.repositories.AvionRepository;
import com.example.aeroportspring.dal.repositories.InterventionRepository;
import com.example.aeroportspring.dal.repositories.MecanoRepository;
import com.example.aeroportspring.pl.models.forms.InterventionForm;
import jakarta.persistence.EntityNotFoundException;
import jdk.jfr.MemoryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionServiceImpl implements InterventionService {

    private  final InterventionRepository interventionRepository;
    private  final MecanoRepository mecanoRepository;

    private  final AvionRepository avionRepository;

    public InterventionServiceImpl(InterventionRepository interventionRepository, MecanoRepository mecanoRepository, AvionRepository avionRepository) {
        this.interventionRepository = interventionRepository;
        this.mecanoRepository = mecanoRepository;
        this.avionRepository = avionRepository;
    }

    @Override
    public Intervention create(InterventionForm interventionForm) {
        Intervention entity = new Intervention();

        entity.setObjet(interventionForm.getObjet());
        entity.setDate(interventionForm.getDate());
        entity.setDuree(interventionForm.getDuree());
        Avion avion =  avionRepository.findById(interventionForm.getAvion()).orElseThrow(() -> new EntityNotFoundException());
        entity.setAvion(avion);


        Mecano mecanoVerificateur = mecanoRepository.findById(interventionForm.getMecanoVerificateur()).orElseThrow(()-> new EntityNotFoundException());
        entity.setMecanoVerificateur(mecanoVerificateur);
        Mecano mecanoReparateur = mecanoRepository.findById(interventionForm.getMecanoReparateur()).orElseThrow(()-> new EntityNotFoundException());
        entity.setMecanoReparateur(mecanoReparateur);

        try {
           if (!mecanoReparateur.getId().equals(mecanoVerificateur.getId())){
                   return interventionRepository.save(entity);


            } else {
                throw new RuntimeException("Les mécanos réparateurs doivent être différents des vérificateurs");
            }


        }catch (RuntimeException e) {
            throw e;
        }

    }

    @Override
    public Intervention update(Long id, InterventionForm interventionForm) {
        Intervention entity = getOne(id);
        entity.setObjet(interventionForm.getObjet());
        entity.setDate(interventionForm.getDate());
        entity.setDuree(interventionForm.getDuree());
        Avion avion =  avionRepository.findById(interventionForm.getAvion()).orElseThrow(() -> new EntityNotFoundException());
        entity.setAvion(avion);

        return interventionRepository.save(entity);
    }

    @Override
    public Intervention getOne(Long id) {
        return interventionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Intervention> findAll() {
       return interventionRepository.findAll();
    }

    @Override
    public Intervention delete(Long id) {
        Intervention entity = getOne(id);
        interventionRepository.delete(entity);
        return entity;
    }


}
