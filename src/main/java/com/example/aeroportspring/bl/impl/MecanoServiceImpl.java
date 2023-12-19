package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.MecanoService;
import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.dal.repositories.MecanoRepository;
import com.example.aeroportspring.dal.repositories.TypeAvionRepository;
import com.example.aeroportspring.pl.models.forms.MecanoForm;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MecanoServiceImpl implements MecanoService {
    
    private final MecanoRepository mecanoRepository;
    private final TypeAvionRepository typeAvionRepository;

    public MecanoServiceImpl(MecanoRepository mecanoRepository, TypeAvionRepository typeAvionRepository) {
        this.mecanoRepository = mecanoRepository;
        this.typeAvionRepository = typeAvionRepository;
    }

    @Override
    public Mecano create(MecanoForm mecano) {
        Mecano entity = new Mecano();
        entity.setNom(mecano.getNom());
        entity.setTel(mecano.getTel());
        entity.setAdresse(mecano.getAdresse());
        entity.setTypeAvion(mecano.getTypeAvionId().stream().map(id->typeAvionRepository.findById(id).get()).collect(Collectors.toSet()));

        return  mecanoRepository.save(entity);
    }

    @Override
    public Mecano update(Long id, MecanoForm mecano) {
        Mecano entity = getOne(id);
        entity.setNom(mecano.getNom());
        entity.setTel(mecano.getTel());
        entity.setAdresse(mecano.getAdresse());
        entity.setTypeAvion(mecano.getTypeAvionId().stream().map(ids->typeAvionRepository.findById(id).get()).collect(Collectors.toSet()));

        return  mecanoRepository.save(entity);
        
    }

    @Override
    public Mecano getOne(Long id) {
        return mecanoRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    @Override
    public List<Mecano> findAll() {
        return mecanoRepository.findAll();
    }

    @Override
    public Mecano delete(Long id) {
        Mecano entity = getOne(id);
        mecanoRepository.delete(entity);
        return entity;
    }


}
