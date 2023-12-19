package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.PiloteService;
import com.example.aeroportspring.dal.models.Pilote;
import com.example.aeroportspring.dal.repositories.PiloteRepository;
import com.example.aeroportspring.pl.models.forms.PiloteForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PiloteServiceImpl implements PiloteService {

    private final PiloteRepository piloteRepository;

    public PiloteServiceImpl(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }

    @Override
    public Pilote create(PiloteForm pilote) {
        Pilote entity = new Pilote();
        entity.setNumBrevet(pilote.getNumBrevet());
        entity.setNom(pilote.getNom());
        entity.setTel(pilote.getTel());
        entity.setAdresse(pilote.getAdresse());
        return piloteRepository.save(entity);
    }

    @Override
    public Pilote update(Long id, PiloteForm pilote) {
        Pilote entity = getOne(id);
        entity.setNumBrevet(pilote.getNumBrevet());
        entity.setNom(pilote.getNom());
        entity.setTel(pilote.getTel());
        entity.setAdresse(pilote.getAdresse());
        return piloteRepository.save(entity);

    }

    @Override
    public Pilote getOne(Long id) {
        return piloteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Pilote> findAll() {
        return piloteRepository.findAll();
    }

    @Override
    public Pilote delete(Long id) {
        Pilote entity = getOne(id);
        piloteRepository.delete(entity);
        return entity;
    }
}
