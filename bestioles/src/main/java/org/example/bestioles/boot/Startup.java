package org.example.bestioles.boot;

import org.example.bestioles.entity.Animal;
import org.example.bestioles.entity.Species;
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

    public Startup(PersonRepository personRepository, SpeciesRepository speciesRepository) {
        this.personRepository = personRepository;
        this.speciesRepository = speciesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=================================================");
        System.out.println("DÉBUT DES TESTS DU REPOSITORY SPECIES");
        System.out.println("=================================================");

        System.out.println("\n--- 1. Liste de toutes les espèces (findAll) ---");
        Iterable<Species> allSpecies = speciesRepository.findAll();
        for (Species s : allSpecies) {
            System.out.println("Espèce existante : " + s.getCommonName() + " (" + s.getLatinName() + ")");
        }

        System.out.println("\n--- 2. Création d'une nouvelle espèce (save) ---");
        Species dragon = new Species();
        dragon.setCommonName("Dragon");
        dragon.setLatinName("Draco ignis");

        Species savedDragon = speciesRepository.save(dragon);
        System.out.println("Espèce créée avec succès ! ID = " + savedDragon.getId());


        System.out.println("\n--- 3. Recherche par ID (findById) ---");
        Optional<Species> foundSpecies = speciesRepository.findById(savedDragon.getId());

        if (foundSpecies.isPresent()) {
            System.out.println("Entité retrouvée en base : " + foundSpecies.get().getCommonName());
        } else {
            System.out.println("Erreur : Entité non trouvée !");
        }


        System.out.println("\n--- 4. Suppression et vérification (delete) ---");
        long countBefore = speciesRepository.count();
        System.out.println("Nombre d'espèces avant suppression : " + countBefore);

        speciesRepository.delete(savedDragon);

        long countAfter = speciesRepository.count();
        System.out.println("Nombre d'espèces après suppression : " + countAfter);

        if (countAfter == countBefore - 1) {
            System.out.println("Succès : L'entité a bien été supprimée.");
        } else {
            System.out.println("Erreur : Le compte ne correspond pas.");
        }

        System.out.println("=================================================");
    }
}
