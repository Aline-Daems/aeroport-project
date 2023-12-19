package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Adresse;
import com.example.aeroportspring.dal.models.Pilote;

public record PiloteDTO (

    Long id,
    String numBrevet,
    String nom,
    Adresse adresse,
    int tel

) {
    public static PiloteDTO fromEntity(Pilote pilote){
        return  new PiloteDTO(pilote.getId(), pilote.getNumBrevet(), pilote.getNom(), pilote.getAdresse(), pilote.getTel());
    }
}
