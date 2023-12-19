package com.example.aeroportspring.pl.models.forms;

import com.example.aeroportspring.dal.models.Intervention;
import com.example.aeroportspring.dal.models.Proprio;
import lombok.Data;

@Data
public class AvionForm {
    private Long id;
    private Long ProprioId;
    private Long typeAvionId;


}
