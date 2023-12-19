package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.TypeAvionService;
import com.example.aeroportspring.dal.models.TypeAvion;
import com.example.aeroportspring.pl.models.dto.TypeAvionDTO;
import com.example.aeroportspring.pl.models.forms.TypeAvionForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeAvion")
public class TypeAvionController {

    public final TypeAvionService typeAvionService;

    public TypeAvionController(TypeAvionService typeAvionService) {
        this.typeAvionService = typeAvionService;
    }

    @PostMapping("/create")
    public void create(@RequestBody TypeAvionForm form) {

        typeAvionService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update (@PathVariable Long id, @RequestBody TypeAvionForm form){

        typeAvionService.update(id,form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAvionDTO> findById(@PathVariable Long id){
        TypeAvion typeAvion = typeAvionService.getOne(id);
        return  ResponseEntity.ok(TypeAvionDTO.fromEntity(typeAvion));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeAvionDTO>>findAll(){
        List<TypeAvion> typeAvionList = typeAvionService.findAll();
        List<TypeAvionDTO> dtos = typeAvionList.stream().map(TypeAvionDTO::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        typeAvionService.delete(id);
    }
}
