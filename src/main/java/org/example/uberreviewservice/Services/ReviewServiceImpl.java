package org.example.uberreviewservice.Services;

import jakarta.persistence.EntityNotFoundException;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review publishReview(Review requestReview) {
        System.out.println("Publishing Review");
        return this.reviewRepository.save(requestReview);
    }

    @Override
    public List<Review> GetAllReviews(){
       return this.reviewRepository.findAll();
    }

    @Override
    public Optional<Review> FindById(Long reviewId) {
        Optional<Review> review;
        try{
            review = Optional.ofNullable(this.reviewRepository.findById(reviewId));
            if(review.isPresent()){
                throw new EntityNotFoundException("Review with id " + reviewId + " not found");
            }
        }catch (Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + reviewId + " not found", reviewId);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", reviewId);

        }
        return review;
    }

    @Override
    public boolean DeleteByID(Long reviewId) {
        try{
            Review review = this.reviewRepository.findById(reviewId);
            if(review != null){
                this.reviewRepository.delete(review);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + reviewId + " not found", reviewId);
            }
            return false;
        }
    }

    @Override
    public Review updateReview (Long reviewId, Review requestReview) {
        try{

            Review review = this.reviewRepository.findById(reviewId);
            if(review == null){
                throw new EntityNotFoundException("Review with id " + reviewId + " not found");
            }
            if(requestReview.getRating()!=null){
                review.setRating(requestReview.getRating());
            }
            if(requestReview.getContent()!=null){
                review.setContent(requestReview.getContent());
            }
            return reviewRepository.save(review);

        }catch (Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + reviewId + " not found", reviewId);
            }

            return null;
        }

    }
}
