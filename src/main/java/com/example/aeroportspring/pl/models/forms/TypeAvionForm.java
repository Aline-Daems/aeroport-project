package com.example.aeroportspring.pl.models.forms;

import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.Piloter;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class TypeAvionForm {

    private String nom;
    private String constructeur;
    private int puissance;
    private int nbPlaces;
  //  private Long mecanos;
    private Long pilotages;

}
