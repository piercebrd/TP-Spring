package org.example.bestioles.service;

import org.example.bestioles.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Integer id);
    Person save(Person person);
    void delete(Integer id);
}
