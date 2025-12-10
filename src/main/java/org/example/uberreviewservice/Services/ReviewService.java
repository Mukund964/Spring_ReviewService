package org.example.uberreviewservice.Services;

import jakarta.transaction.Transactional;
import org.example.uberreviewservice.Models.*;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.PassengerRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.Repositories.driverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService implements CommandLineRunner{
    private ReviewRepository reviewRepo;
    private BookingRepository bookingRepo;
    private driverRepository driverRepo;
    private PassengerRepository passengerRepo;

    public ReviewService(ReviewRepository reviewRepo, BookingRepository bookingRepo, driverRepository driverRepo, PassengerRepository passengerRepo) {
        this.reviewRepo=reviewRepo;
        this.bookingRepo=bookingRepo;
        this.driverRepo=driverRepo;
        this.passengerRepo=passengerRepo;
    }
//
//
//
//
//    Driver driver_d1 = driverRepo.findById(3).get();
//        passenger p1 = passengerRepo.findById(1).get();
//
//        Review review = Review.builder()
//                .rating(5.0)
//                .content("This is a test review")
//                .build();
//
//
//        Booking booking = Booking.builder()
//                .BookingStatus(BookingStatus.valueOf("COMPLETED"))
//                .StartTime(LocalDateTime.now())
//                .EndTime(LocalDateTime.now())
//                .driver(driver_d1)
//                .passenger(p1)
//                .TotalDistance(15L)
//                .review(review)
//                .build();
//
//        bookingRepo.save(booking);
//        reviewRepo.save(review);


    @Override
    public void run(String... args) throws Exception {
        // N+1 problem
//        List<Booking> bookings= bookingRepo.findAllByPassengerId(1);
//        for(Booking b : bookings){
//            System.out.println(b.getDriver().getName());
//        }

        List<Integer> driverIds = List.of(1,2,3);
        List<Driver> drivers = driverRepo.findAllByIdIn(driverIds);

        for(Driver driver:drivers){
            System.out.println(driver.getBookings());
        }

//       Optional<Driver> d =  driverRepo.RawfindByIdAndLicenseNo(1,"123Ab");
//        System.out.println(d.get().getName());
//
//        Optional<Driver> d1 =  driverRepo.hqlfindByIdAndLicenseNo(1,"123Ab");
//        System.out.println(d1.get().getName());


    }




    }



