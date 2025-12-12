package org.example.bestioles.service;

import org.example.bestioles.entity.Species;
import org.example.bestioles.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    private SpeciesRepository speciesRepository;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species findSpeciesById(Integer id) {
        return speciesRepository.findById(id).orElse(null);
    }

    public List<Species> findAllSpecies() {
        return speciesRepository.findAll();
    }

    public void deleteSpecies(Integer id) {
        speciesRepository.deleteById(id);
    }

    public Species saveSpecies(Species species) {
        if (species.getId() != null) {
            throw new IllegalArgumentException("ID must be null for creation");
        }
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Species species, Integer id) {
        return speciesRepository.save(species);
    }



}
