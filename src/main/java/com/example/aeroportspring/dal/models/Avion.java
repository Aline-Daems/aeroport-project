package com.example.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numIma")
    private Long id;

    @ManyToOne
   @JoinColumn(name="ProprioId")
    private Proprio proprio;

    @ManyToOne
    @JoinColumn(name="PiloteId")
    private Pilote pilote;

    @ManyToOne
    private TypeAvion typeAvion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
