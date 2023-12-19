package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.Pilote;
import com.example.aeroportspring.pl.models.forms.PiloteForm;

import java.util.List;

public interface PiloteService {

    Pilote create(PiloteForm pilote);

    Pilote update(Long id, PiloteForm pilote);

    Pilote getOne(Long id);

    List<Pilote> findAll();

    Pilote delete(Long id);
}
