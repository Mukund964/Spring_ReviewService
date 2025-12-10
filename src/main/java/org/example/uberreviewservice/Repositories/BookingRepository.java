package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;

import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    List<Booking> findAllByDriverIn(List<Driver> drivers);

}
