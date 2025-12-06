package org.example.uberreviewservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Enumeration;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel {
    @Enumerated(EnumType.STRING)
    private BookingStatus BookingStatus;


    private LocalDateTime StartTime;
    private LocalDateTime EndTime;

    private Long TotalDistance;
}
