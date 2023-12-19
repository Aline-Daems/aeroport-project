package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.TypeAvionService;
import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.Piloter;
import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.dal.repositories.MecanoRepository;
import com.example.aeroportspring.dal.repositories.TypeAvionRepository;
import com.example.aeroportspring.pl.models.forms.TypeAvionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAvionServiceImpl implements TypeAvionService {

    private final TypeAvionRepository typeAvionRepository;
    private final MecanoRepository mecanoRepository;
    public TypeAvionServiceImpl(TypeAvionRepository typeAvionRepository, MecanoRepository mecanoRepository) {
        this.typeAvionRepository = typeAvionRepository;
        this.mecanoRepository = mecanoRepository;
    }


    @Override
    public TypeAvion create(TypeAvionForm typeAvion) {

        TypeAvion entity = new TypeAvion();
        entity.setNom(typeAvion.getNom());
        entity.setConstructeur(typeAvion.getConstructeur());
        entity.setPuissance(typeAvion.getPuissance());
        entity.setNbPlaces(typeAvion.getNbPlaces());
      //  Mecano mecanos = mecanoRepository.findById(typeAvion.getMecanos()).orElseThrow(()-> new EntityNotFoundException());
//        entity.setMecanos((List<Mecano>) mecanos);


        return typeAvionRepository.save(entity);
    }

    @Override
    public TypeAvion update(Long id, TypeAvionForm typeAvion) {
        TypeAvion entity = getOne(id);
        entity.setNom(typeAvion.getNom());
        entity.setConstructeur(typeAvion.getConstructeur());
        entity.setPuissance(typeAvion.getPuissance());
        entity.setNbPlaces(typeAvion.getNbPlaces());
     //   Mecano mecanos = mecanoRepository.findById(typeAvion.getMecanos()).orElseThrow(()-> new EntityNotFoundException());
//        entity.setMecanos((List<Mecano>) mecanos);

        return typeAvionRepository.save(entity);
    }

    @Override
    public TypeAvion getOne(Long id) {
        return typeAvionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TypeAvion> findAll() {
        return typeAvionRepository.findAll();
    }

    @Override
    public TypeAvion delete(Long id) {
       TypeAvion entity = getOne(id);
       typeAvionRepository.delete(entity);
       return entity;
    }
}
