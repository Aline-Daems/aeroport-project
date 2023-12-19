package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.AvionService;
import com.example.aeroportspring.dal.models.Avion;
import com.example.aeroportspring.pl.models.dto.AvionDto;
import com.example.aeroportspring.pl.models.forms.AvionForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avion")
public class AvionController {

    public final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/create")
    public void create (@RequestBody AvionForm form){
        avionService.create(form);

    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody AvionForm avionForm){
         avionService.update(id, avionForm);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<AvionDto> findById(@PathVariable Long id){

     Avion avion = avionService.getOne(id);

     return ResponseEntity.ok(AvionDto.fromEntity(avion));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvionDto>> findAll(){

        List<Avion> avions = avionService.findAll();
        List<AvionDto> dtos = avions.stream().map(AvionDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        avionService.delete(id);
    }

}
