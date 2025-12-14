package org.example.uberreviewservice.Controllers;

import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Services.ReviewService;
import org.example.uberreviewservice.adaptors.createReviewRequestToReviewAdaptor;
import org.example.uberreviewservice.dtos.reviewRequestDto;
import org.example.uberreviewservice.dtos.reviewResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    //@Autowired
    private final ReviewService reviewService;
    private final createReviewRequestToReviewAdaptor  createReviewRequestToReviewAdaptor;


    public ReviewController(ReviewService reviewService,createReviewRequestToReviewAdaptor  createReviewRequestToReviewAdaptor) {
        this.reviewService = reviewService;
        this.createReviewRequestToReviewAdaptor = createReviewRequestToReviewAdaptor;
    }


    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody reviewRequestDto reviewRequestDto) {
        try {
            Review convertedReview = createReviewRequestToReviewAdaptor.convertDto(reviewRequestDto);
            if(convertedReview == null){
                return new ResponseEntity<>("Booking not exist",HttpStatus.BAD_REQUEST);

            }

            Review review = reviewService.publishReview(convertedReview);
//            reviewResponseDto responseDto = reviewResponseDto.builder()
//                    .id(Long.valueOf(review.getId()))
//                    .rating(review.getRating())
//                    .content(review.getContent())
//                    .createdAt(review.getCreatedAt())
//                    .updatedAt(review.getUpdatedAt())
//                    .build();

            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        try{
            List<Review> reviews = reviewService.GetAllReviews();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> GetReviewById(@PathVariable Long reviewId) {
        try{
            Optional<Review> review = reviewService.FindById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete/{reviewId}")
    public ResponseEntity<?>  DeleteReviewById(@PathVariable Long reviewId) {
        try{
            boolean isDeleted = reviewService.DeleteByID(reviewId);
            if(isDeleted){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review requestReview) {
        try{
            Review review = reviewService.updateReview(reviewId,requestReview);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
