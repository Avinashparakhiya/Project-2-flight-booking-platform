package com.example.flyaway.FlyAway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyAwayrepositaryForAdmin extends CrudRepository<Admin, Integer> {

    Admin findByMobileno(String mobileno);
}
