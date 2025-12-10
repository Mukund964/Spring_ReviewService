package org.example.uberreviewservice.Services;

import jakarta.transaction.Transactional;
import org.example.uberreviewservice.Models.*;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public Review publishReview(Review requestReview);

    public List<Review> GetAllReviews();

    public Optional<Review> FindById(Long reviewId);

    public boolean DeleteByID(Long reviewId);

    public Review updateReview(Long reviewId,Review requestReview);
}



