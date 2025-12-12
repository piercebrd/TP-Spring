package org.example.bestioles.controller;


import jakarta.validation.Valid;
import org.example.bestioles.entity.Animal;
import org.example.bestioles.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animals")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/create")
    public Animal createAnimal(@Valid @RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/update/{id}")
    public Animal updateAnimal(@Valid @RequestBody Animal animal, @PathVariable("id") Integer id) {
        animal.setId(id);
        return animalService.updateAnimal(animal);
    }

    @GetMapping()
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animalService.getAnimalById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnimalById(@PathVariable Integer id) {
        animalService.deleteAnimalById(id);
    }


}
