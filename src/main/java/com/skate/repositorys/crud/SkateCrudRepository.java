package com.skate.repositorys.crud;

import com.skate.model.Skate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkateCrudRepository extends CrudRepository<Skate,Integer> {

    @Query("SELECT c.year, COUNT(c.year) from Skate AS c group by c.year order by COUNT(c.year) DESC")
    public List<Object[]> countTotalBoatByYear();

}
