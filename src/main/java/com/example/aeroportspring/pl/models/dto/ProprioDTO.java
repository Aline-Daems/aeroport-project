package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Adresse;
import com.example.aeroportspring.dal.models.Proprio;
import lombok.Data;


public record ProprioDTO(

     Long id,
     String nom,
     Adresse adresse,
     int tel
) {

    public static ProprioDTO fromEntity(Proprio proprio){
        return new ProprioDTO(proprio.getId(), proprio.getNom(), proprio.getAdresse(), proprio.getTel());
    }
}
