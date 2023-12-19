package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.pl.models.forms.MecanoForm;

import java.util.List;

public interface MecanoService {

    Mecano create(MecanoForm form);

    Mecano update(Long id, MecanoForm form);

    Mecano getOne(Long id);

    List<Mecano> findAll();

    Mecano delete(Long id);



}
