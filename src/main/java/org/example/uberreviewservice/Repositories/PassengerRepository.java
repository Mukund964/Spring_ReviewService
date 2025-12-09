package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<passenger, Integer> {
}
