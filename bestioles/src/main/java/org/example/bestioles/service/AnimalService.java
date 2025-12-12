package org.example.bestioles.service;

import org.example.bestioles.entity.Animal;
import org.example.bestioles.entity.Person;
import org.example.bestioles.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Integer id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal createAnimal(Animal animal) {
        if (animal.getId() != null) {
            throw new IllegalArgumentException("ID must be null for creation");
        }
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimalById(Integer id) {
        Animal animal = animalRepository.findById(id).orElse(null);
        if (animal.getOwners() != null) {
            for (Person person : animal.getOwners()) {
                person.getAnimals().remove(animal);
            }
        }
        animalRepository.deleteById(id);
    }
}
