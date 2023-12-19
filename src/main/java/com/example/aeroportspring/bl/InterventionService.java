package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.Intervention;
import com.example.aeroportspring.pl.models.forms.InterventionForm;

import java.util.List;

public interface InterventionService {

    Intervention create (InterventionForm interventionForm);

    Intervention update(Long id, InterventionForm interventionForm);

    Intervention getOne(Long id);
    List<Intervention> findAll();

    Intervention delete(Long id);
}
