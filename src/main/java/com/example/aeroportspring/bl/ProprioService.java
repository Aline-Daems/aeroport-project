package com.example.aeroportspring.bl;

import com.example.aeroportspring.dal.models.Proprio;
import com.example.aeroportspring.pl.models.forms.ProprioForm;

import java.util.List;

public interface ProprioService {

    Proprio create(ProprioForm proprio);

    Proprio update(Long id, ProprioForm proprio);

    Proprio getOne(Long id);

    List<Proprio> findAll();

    Proprio delete(Long id);
}
