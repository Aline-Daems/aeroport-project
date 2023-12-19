package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Mecano extends Personne {
    @ManyToMany
    private Set<TypeAvion> typeAvion;


}
