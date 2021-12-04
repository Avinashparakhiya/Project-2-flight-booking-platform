package com.example.flyaway.FlyAway;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlyAwayrepositary extends CrudRepository<Flight, Integer> {

    @Query("select f from Flight f where f.date=?1 and f.destination=?2 and f.person=?3 and f.source=?4")
    List<Flight> findFlights(String date, String destination, String person, String source);
}
