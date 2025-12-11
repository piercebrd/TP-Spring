package org.example.bestioles.repository;

import org.example.bestioles.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    Species findFirstByCommonName(String commonName);

    List<Species> findByLatinNameContainingIgnoreCase(String latinName);

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonName();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :name")
    List<Species> findByCommonNameLike(@Param("name") String name);

}
