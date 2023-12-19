package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.ProprioService;
import com.example.aeroportspring.dal.models.Proprio;
import com.example.aeroportspring.pl.models.dto.ProprioDTO;
import com.example.aeroportspring.pl.models.forms.ProprioForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprio")
public class ProprioController {

    public final ProprioService proprioService;


    public ProprioController(ProprioService proprioService) {
        this.proprioService = proprioService;
    }

    @PostMapping("/create")
    public void create(@RequestBody ProprioForm form){
         proprioService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody ProprioForm form){
         proprioService.update(id, form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProprioDTO> findById(@PathVariable Long id){
        Proprio proprio = proprioService.getOne(id);
        return  ResponseEntity.ok(ProprioDTO.fromEntity(proprio));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProprioDTO>> findAll(){

        List<Proprio> proprios = proprioService.findAll();
        List<ProprioDTO> dtos = proprios.stream().map(ProprioDTO::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        proprioService.delete(id);
    }
}
