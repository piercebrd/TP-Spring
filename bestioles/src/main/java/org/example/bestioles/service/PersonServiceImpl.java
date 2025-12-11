package org.example.bestioles.service;

import org.example.bestioles.entity.Person;
import org.example.bestioles.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public Person findById(Integer id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
