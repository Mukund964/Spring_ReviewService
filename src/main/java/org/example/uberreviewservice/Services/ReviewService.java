package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepo;

    public ReviewService(ReviewRepository reviewRepo){
        this.reviewRepo=reviewRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating Review");

        Review review = Review.builder()
                .rating(5.0)
                .content("This is a test review")
                .build();

        reviewRepo.save(review);
    }
}
