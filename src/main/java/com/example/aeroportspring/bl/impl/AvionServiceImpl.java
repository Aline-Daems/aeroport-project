package com.example.aeroportspring.bl.impl;

import com.example.aeroportspring.bl.AvionService;
import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.dal.models.Proprio;
import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.dal.repositories.AvionRepository;
import com.example.aeroportspring.dal.repositories.PiloteRepository;
import com.example.aeroportspring.dal.repositories.ProprioRepository;
import com.example.aeroportspring.dal.repositories.TypeAvionRepository;
import com.example.aeroportspring.pl.models.forms.AvionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {

    private final AvionRepository avionRepository;
    private final ProprioRepository proprioRepository;
    private final TypeAvionRepository typeAvionRepository;

    private final PiloteRepository piloteRepository;
    public AvionServiceImpl(AvionRepository avionRepository, ProprioRepository proprioRepository, TypeAvionRepository typeAvionRepository, PiloteRepository piloteRepository) {
        this.avionRepository = avionRepository;
        this.proprioRepository = proprioRepository;
        this.typeAvionRepository = typeAvionRepository;
        this.piloteRepository = piloteRepository;
    }

    @Override
    public Avion create(AvionForm avion) {
        Avion entity = new Avion();
        entity.setId(avion.getId());
        Proprio proprio = proprioRepository.findById(avion.getProprioId()).orElseThrow(()-> new EntityNotFoundException("Proprio non trouvé"));
        entity.setProprio(proprio);
        TypeAvion typeAvion = typeAvionRepository.findById(avion.getTypeAvionId()).orElseThrow(() -> new EntityNotFoundException());
        entity.setTypeAvion(typeAvion);
        return avionRepository.save(entity);
    }

    @Override
    public Avion update(Long id, AvionForm avion) {
        Avion entity = getOne(id);
        entity.setId(entity.getId());
        Proprio proprio = proprioRepository.findById(avion.getProprioId()).orElseThrow(()-> new EntityNotFoundException("Proprio non trouvé"));
        entity.setProprio(proprio);
        TypeAvion typeAvion = typeAvionRepository.findById(avion.getTypeAvionId()).orElseThrow(() -> new EntityNotFoundException());
        entity.setTypeAvion(typeAvion);

        return avionRepository.save(entity);
    }

    @Override
    public Avion getOne(Long id) {
        return avionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Avion> findAll() {
        return avionRepository.findAll();
    }

    @Override
    public Avion delete(Long id) {
        Avion entity = getOne(id);
        avionRepository.delete(entity);
        return entity;
    }
}
