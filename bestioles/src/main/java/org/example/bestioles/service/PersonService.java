package org.example.bestioles.service;

import org.example.bestioles.entity.Person;
import org.example.bestioles.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        if (person.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'ID ne doit pas être fourni pour une création");
        }
        return personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }




}
