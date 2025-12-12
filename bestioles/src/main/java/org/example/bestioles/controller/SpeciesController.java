package org.example.bestioles.controller;


import jakarta.validation.Valid;
import org.example.bestioles.entity.Species;
import org.example.bestioles.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/species")
public class SpeciesController {

    private SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesService.findAllSpecies();
    }

    @GetMapping("{id}")
    public Species getSpeciesById(@PathVariable Integer id) {
        return speciesService.findSpeciesById(id);
    }

    @PostMapping("/create")
    public Species createSpecies(@RequestBody @Valid Species species) {
        return speciesService.saveSpecies(species);
    }

    @PutMapping("/update/{id}")
    public Species updateSpecies(@RequestBody @Valid Species species, @PathVariable("id") Integer id) {
        species.setId(id);
        return speciesService.updateSpecies(species, id);
    }
}
