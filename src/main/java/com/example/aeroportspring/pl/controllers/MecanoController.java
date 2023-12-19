package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.MecanoService;
import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.pl.models.dto.MecanoDTO;
import com.example.aeroportspring.pl.models.forms.MecanoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecano")
public class MecanoController {

    public final MecanoService mecanoService;

    public MecanoController(MecanoService mecanoService) {
        this.mecanoService = mecanoService;
    }

    @PostMapping("/create")
    public void create(@RequestBody MecanoForm form) {
        mecanoService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody MecanoForm form){
        mecanoService.update(id,form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanoDTO> findById(@PathVariable Long id){
        Mecano mecano = mecanoService.getOne(id);
        return ResponseEntity.ok(MecanoDTO.fromEntity(mecano));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MecanoDTO>> findAll(){
        List<Mecano> mecanos = mecanoService.findAll();
        List<MecanoDTO> dtos =  mecanos.stream().map(MecanoDTO::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        mecanoService.delete(id);
    }
}
