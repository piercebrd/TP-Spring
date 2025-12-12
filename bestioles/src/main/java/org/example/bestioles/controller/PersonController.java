package org.example.bestioles.controller;

import jakarta.validation.Valid;
import org.example.bestioles.entity.Person;
import org.example.bestioles.repository.PersonRepository;
import org.example.bestioles.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/persons")
public class PersonController {

    private PersonService personService;

    private PersonRepository personRepository;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.findPersonById(id);
    }

    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personService.findAllPersons();
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person person) {
        person.setId(id);
        return personService.updatePerson(person);
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody @Valid Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.deletePerson(id);
    }

    @GetMapping("/page")
    public Page<Person> getPersons(Pageable pageable) {
        return personRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }
}
