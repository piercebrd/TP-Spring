package org.example.bestioles.controller;

import org.example.bestioles.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private PersonService personService;

    public Controller(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("test")
    public String list() {
        return personService.findAll().toString();
    }
}
