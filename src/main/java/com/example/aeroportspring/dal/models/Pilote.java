package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Pilote  extends Personne{

    private String numBrevet;

    @ManyToMany
    private List<TypeAvion> typeAvionList;

    @OneToMany(mappedBy = "pilote")
    private Set<Piloter> pilotages;

}
