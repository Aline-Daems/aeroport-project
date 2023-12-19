package com.example.aeroportspring.pl.models.forms;

import com.example.aeroportspring.dal.models.Avion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Data
public class InterventionForm {

    private String objet;
    private LocalDate date;
    private int duree;
    private Long avion;
    private Long mecanoVerificateur;
    private Long mecanoReparateur;

}
