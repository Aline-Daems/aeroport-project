package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numUnique")
    private Long id;
    private String objet;
    @Past(message = "La date doit être dans le passé")
    private LocalDate date;
    @Min(value = 1 , message = "La valeur doit être plus grand que 0")
    private int duree;
    @ManyToOne
    @JoinColumn(name="numIma")
    private Avion avion;
    @ManyToOne
    private Mecano mecanoVerificateur;
    @ManyToOne
    private Mecano mecanoReparateur;







}
