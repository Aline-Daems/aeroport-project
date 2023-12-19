package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class TypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "modeleId")
    private Long id;

    private String nom;
    private String constructeur;
    @Min(value = 1 , message = "La valeur doit être plus grand que 0")
    private int puissance;
    @Min(value = 1 , message = "La valeur doit être plus grand que 0")
    private int nbPlaces;

//    @ManyToMany
//    private List<Mecano> mecanos;

    @OneToMany(mappedBy = "typeAvion")
    private Set<Piloter> pilotages;



}
