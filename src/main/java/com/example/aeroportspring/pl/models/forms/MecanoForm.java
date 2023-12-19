package com.example.aeroportspring.pl.models.forms;

import com.example.aeroportspring.dal.models.Adresse;
import com.example.aeroportspring.dal.models.TypeAvion;
import lombok.Data;

import java.util.List;

@Data
public class MecanoForm {
    private String nom;

    private Adresse adresse;

    private int tel;
    List<Long> typeAvionId;
}

