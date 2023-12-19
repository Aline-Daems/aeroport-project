package com.example.aeroportspring.pl.models.dto;

import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.dal.models.Intervention;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Data
public class InterventionDTO {

    private Long id;
    private String objet;
    private LocalDate date;
    private int duree;
    private Avion avion;

    public InterventionDTO(Long id, String objet, LocalDate date, int duree, Avion avion) {
        this.id = id;
        this.objet = objet;
        this.date = date;
        this.duree = duree;
        this.avion = avion;
    }

    public static InterventionDTO fromEntity(Intervention intervention){

        return new InterventionDTO(intervention.getId(), intervention.getObjet(), intervention.getDate(), intervention.getDuree(), intervention.getAvion());
    }
}
