package com.example.aeroportspring.pl.models.forms;

import com.example.aeroportspring.dal.models.Adresse;
import lombok.Data;

@Data
public class ProprioForm {

    private String nom;

    private Adresse adresse;

    private int tel;
}
