package org.example.bestioles.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int age;

    @Column
    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String login;

    private String mdp;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean active = true;

    @ManyToMany
    @JoinTable(name = "person_animals", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "animals_id"))
    @ToString.Exclude
    private Set<Animal> animals;

    @ManyToMany
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles;
}
