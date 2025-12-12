package org.example.uberreviewservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewRequestDto {

    private Long BookingId;
    private String Content;
    private Double Ratings;
}
