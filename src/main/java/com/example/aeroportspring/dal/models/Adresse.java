package com.example.aeroportspring.dal.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Adresse {
    @Min(value = 1, message ="Votre numéro de maison doit obligatoirement être au dessus de 0")
    private int num;
    private String rue;
    @Max(value=99999, message="Le code postal n'est pas correct")
    private int postal;
    private String ville;
}
