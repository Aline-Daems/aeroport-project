package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.dal.models.Intervention;
import com.example.aeroportspring.dal.models.Proprio;
import com.example.aeroportspring.dal.models.TypeAvion;
import lombok.Data;

@Data
public class AvionDto {
    private Long id;
    private Proprio proprio;
    private TypeAvion typeAvion;

    public AvionDto(Long id, Proprio proprio, TypeAvion typeAvion) {
        this.id = id;
        this.proprio = proprio;
        this.typeAvion = typeAvion;

    }

    public static AvionDto fromEntity(Avion avion){

        return new AvionDto(avion.getId(), avion.getProprio(), avion.getTypeAvion());
    }
}
