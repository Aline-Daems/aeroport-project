package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.pl.models.forms.AvionForm;

import java.util.List;

public interface AvionService {

    Avion create(AvionForm avion);
    Avion update(Long id, AvionForm avion);
    Avion getOne(Long id);
    List<Avion> findAll();
    Avion delete(Long id);


}
