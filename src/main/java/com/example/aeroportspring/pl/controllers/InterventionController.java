package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.InterventionService;
import com.example.aeroportspring.dal.models.Intervention;
import com.example.aeroportspring.pl.models.dto.InterventionDTO;
import com.example.aeroportspring.pl.models.forms.InterventionForm;
import io.swagger.models.auth.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intervention")
public class InterventionController {
    public final InterventionService interventionService;


    public InterventionController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }

    @PostMapping("/create")
    public void create (@RequestBody InterventionForm form){
         interventionService.create(form);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InterventionDTO> update(@PathVariable Long id, @RequestBody InterventionForm interventionForm){
        Intervention intervention = interventionService.update(id, interventionForm);
        return ResponseEntity.ok(InterventionDTO.fromEntity(intervention));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterventionDTO> findById(@PathVariable Long id){

        Intervention intervention = interventionService.getOne(id);

        return  ResponseEntity.ok(InterventionDTO.fromEntity(intervention));
    }

    @GetMapping("/all")
    public ResponseEntity<List<InterventionDTO>>findAll(){

        List<Intervention> interventions = interventionService.findAll();
        List<InterventionDTO> dtos = interventions.stream().map(InterventionDTO::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable Long id){
        interventionService.delete(id);

    }

}
