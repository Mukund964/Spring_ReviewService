package org.example.uberreviewservice.adaptors;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.dtos.reviewRequestDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class createReviewRequestToReviewAdaptorImpl implements createReviewRequestToReviewAdaptor {

    BookingRepository bookingRepo;

    createReviewRequestToReviewAdaptorImpl(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Review convertDto(reviewRequestDto RequestDto) {


        Long BookingId = RequestDto.getBookingId();
        Optional<Booking> booking = bookingRepo.findById(BookingId);
        return booking.map(value ->
                    Review.builder()
                    .rating(RequestDto.getRatings())
                    .content(RequestDto.getContent())
                    .booking(value)
                    .build()).orElse(null);

    }
}
