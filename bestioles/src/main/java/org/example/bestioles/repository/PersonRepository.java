package org.example.bestioles.repository;

import org.example.bestioles.entity.Animal;
import org.example.bestioles.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

    List<Person> findByLastnameOrFirstname(String lastname, String firstname);

    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("SELECT p FROM Person p WHERE p.age >= :min AND p.age <= :max")
    List<Person> findByAgeRange(@Param("min") Integer min, @Param("max") Integer max);

    @Query("SELECT p FROM Person p WHERE :animal MEMBER OF p.animals")
    List<Person> findOwnersOf(@Param("animal") Animal animal);

}
