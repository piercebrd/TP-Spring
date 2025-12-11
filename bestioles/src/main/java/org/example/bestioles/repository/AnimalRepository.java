package org.example.bestioles.repository;

import org.example.bestioles.entity.Animal;
import org.example.bestioles.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);
}
