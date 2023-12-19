package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Piloter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "piloterId")
    private Long id;

    @Min(value = 0, message ="La valeur doit être au moins de 0 ou plus grand")
    private int nbVols;

    @ManyToOne
    @JoinColumn(name="personneId")
    private Pilote pilote;

    @ManyToOne
    @JoinColumn(name="modeleId")
    private TypeAvion typeAvion;


}
