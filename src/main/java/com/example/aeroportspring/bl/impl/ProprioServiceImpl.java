package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.ProprioService;
import com.example.aeroportspring.dal.models.Proprio;
import com.example.aeroportspring.dal.repositories.ProprioRepository;
import com.example.aeroportspring.pl.models.forms.ProprioForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprioServiceImpl implements ProprioService {

    private final ProprioRepository proprioRepository;

    public ProprioServiceImpl(ProprioRepository proprioRepository) {
        this.proprioRepository = proprioRepository;
    }

    @Override
    public Proprio create(ProprioForm proprio) {
       Proprio entity = new Proprio();
       entity.setNom(proprio.getNom());
       entity.setTel(proprio.getTel());
       entity.setAdresse(proprio.getAdresse());

       return  proprioRepository.save(entity);
    }

    @Override
    public Proprio update(Long id, ProprioForm proprio) {
        Proprio entity = getOne(id);
        entity.setNom(proprio.getNom());
        entity.setTel(proprio.getTel());
        entity.setAdresse(proprio.getAdresse());
        return  proprioRepository.save(entity);

    }

    @Override
    public Proprio getOne(Long id) {
        return proprioRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Proprio> findAll() {
        return proprioRepository.findAll();
    }

    @Override
    public Proprio delete(Long id) {
        Proprio entity = getOne(id);

        proprioRepository.delete(entity);

        return entity;
    }
}
