package org.example.uberreviewservice.adaptors;

import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.dtos.reviewRequestDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public interface createReviewRequestToReviewAdaptor {
    public Review convertDto(reviewRequestDto RequestDto);
}
