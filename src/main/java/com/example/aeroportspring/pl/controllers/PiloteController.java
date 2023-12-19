package com.example.aeroportspring.pl.controllers;

import com.example.aeroportspring.bl.PiloteService;
import com.example.aeroportspring.dal.models.Pilote;
import com.example.aeroportspring.dal.repositories.PiloteRepository;
import com.example.aeroportspring.pl.models.dto.PiloteDTO;
import com.example.aeroportspring.pl.models.forms.PiloteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilote")
public class PiloteController {

    public final PiloteService piloteService;

    public PiloteController(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    @PostMapping("/create")
    public void create(@RequestBody PiloteForm form) {
        piloteService.create(form);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody PiloteForm form) {
        piloteService.update(id, form);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PiloteDTO> findById(@PathVariable Long id) {
        Pilote pilote = piloteService.getOne(id);
        return ResponseEntity.ok(PiloteDTO.fromEntity(pilote));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PiloteDTO>> findAll(){
        List<Pilote> pilotes = piloteService.findAll();
        List<PiloteDTO> dtos = pilotes.stream().map(PiloteDTO::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        piloteService.delete(id);
    }
}

