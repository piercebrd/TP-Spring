package org.example.bestioles.boot;

import org.example.bestioles.entity.Animal;
import org.example.bestioles.entity.Person;
import org.example.bestioles.entity.Species;
import org.example.bestioles.repository.AnimalRepository;
import org.example.bestioles.repository.PersonRepository;
import org.example.bestioles.repository.SpeciesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class Startup implements CommandLineRunner {

    private PersonRepository personRepository;
    private SpeciesRepository speciesRepository;
    private AnimalRepository animalRepository;

    public Startup(PersonRepository personRepository, SpeciesRepository speciesRepository, AnimalRepository animalRepository) {
        this.personRepository = personRepository;
        this.speciesRepository = speciesRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> colors = List.of("Noir", "Blanc");
        List<Animal> animauxNoirOuBlanc = animalRepository.findByColorIn(colors);
        System.out.println("Animaux noirs ou blancs : " + animauxNoirOuBlanc.size());

        List<Person> vieux = personRepository.findByAgeGreaterThanEqual(50);
        vieux.forEach(p -> System.out.println(p.getFirstname() + " a " + p.getAge() + " ans."));

        List<Species> species = speciesRepository.findAllOrderedByCommonName();
        species.forEach(species1 -> System.out.println(species1));

        List<Species> species2 = speciesRepository.findByCommonNameLike("Chat");
        species2.forEach(s -> System.out.println(s));

        Animal sampleAnimal = animalRepository.findById(1).orElse(null);
        List<Person> owners = personRepository.findOwnersOf(sampleAnimal);
        owners.forEach(p -> System.out.println(p));

        Animal notOwnedAnimal = new Animal();
        notOwnedAnimal.setColor("Gris");
        notOwnedAnimal.setName("Pierce");
        notOwnedAnimal.setSex("M");
        notOwnedAnimal.setSpecies(speciesRepository.findById(1).get());
        animalRepository.save(notOwnedAnimal);

        boolean owned = animalRepository.isOwned(notOwnedAnimal);

        if (owned) {
            System.out.println(notOwnedAnimal.getName() + " a au moins un maître");
        } else {
            System.out.println(notOwnedAnimal.getName() + " n'a pas de maître");
        }

    }
}
