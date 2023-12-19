package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.TypeAvion;
import lombok.Data;

import java.util.List;


public record TypeAvionDTO(

        Long id,
        String nom,
        String constructeur,
        int puissance,
        int nbPlaces

) {


    public static TypeAvionDTO fromEntity(TypeAvion typeAvion) {

        return new TypeAvionDTO(typeAvion.getId(), typeAvion.getNom(), typeAvion.getConstructeur(), typeAvion.getPuissance(), typeAvion.getNbPlaces());
    }


}
