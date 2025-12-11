package org.example.bestioles.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.bestioles.entity.Person;
import org.example.bestioles.repository.PersonRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Transactional
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deletePersonWithoutAnimal() {
        String selectQuery = "SELECT p FROM Person p WHERE p.animals IS EMPTY";

        List<Person> personsToDelete = entityManager.createQuery(selectQuery, Person.class).getResultList();

        int count = 0;
        for (Person p : personsToDelete) {
            entityManager.remove(p);
            count++;
        }
        System.out.println(count + " personnes sans animaux ont été supprimées.");
    }


    @Override
    public void createRandomPersons(Integer count) {
        for (int i = 0; i < count; i++) {
            Person p = new Person();

            String randomStr = UUID.randomUUID().toString().substring(0, 8);

            p.setFirstname("Prenom-" + randomStr);
            p.setLastname("Nom-" + i);
            p.setAge(new Random().nextInt(100));
            p.setActive(true);
            p.setMdp("password123");

            p.setLogin("user-" + randomStr + "-" + i);

            entityManager.persist(p);
        }
        System.out.println(count + " nouvelles personnes ont été créées.");
    }
}
