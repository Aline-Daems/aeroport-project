package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personneId")
    private Long id;

    private String nom;
    @Embedded
    private Adresse adresse;

    private int tel;


}
