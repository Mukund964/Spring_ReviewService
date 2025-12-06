package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.BookingStatus;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepo;
    private BookingRepository bookingRepo;

    public ReviewService(ReviewRepository reviewRepo, BookingRepository bookingRepo) {
        this.reviewRepo=reviewRepo;
        this.bookingRepo=bookingRepo;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating Review");

        Review review = Review.builder()
                .rating(5.0)
                .content("This is a test review")
                .build();

        Booking booking = Booking.builder()
                .BookingStatus(BookingStatus.valueOf("COMPLETED"))
                .StartTime(LocalDateTime.now())
                .EndTime(LocalDateTime.now())
                .TotalDistance(15L)
                .review(review)
                .build();

        bookingRepo.save(booking);
        reviewRepo.save(review);

    }
}
