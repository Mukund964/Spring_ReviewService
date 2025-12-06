package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
