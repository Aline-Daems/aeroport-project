package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.TypeAvion;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
public class MecanoDTO {


    private Set<TypeAvion> typeAvion;

    public MecanoDTO(Set<TypeAvion> typeAvion) {
        this.typeAvion = typeAvion;
    }

    public static MecanoDTO fromEntity(Mecano mecano){
        return new MecanoDTO(mecano.getTypeAvion());
    }
}
