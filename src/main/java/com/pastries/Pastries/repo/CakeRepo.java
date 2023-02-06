package com.pastries.Pastries.repo;

import com.pastries.Pastries.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CakeRepo extends JpaRepository<Cake, Long> {

    void deleteCakeById(Long id); //Query Method, So spring will create a query to delete an id where id = id the id we are passing there

    Optional<Cake> findCakeById(Long id);
}
