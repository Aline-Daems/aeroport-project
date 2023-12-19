package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.pl.models.forms.TypeAvionForm;

import java.util.List;

public interface TypeAvionService {

    TypeAvion create(TypeAvionForm typeAvion);
    TypeAvion update(Long id, TypeAvionForm typeAvion);
    TypeAvion getOne(Long id);
    List<TypeAvion> findAll();
    TypeAvion delete(Long id);
}
