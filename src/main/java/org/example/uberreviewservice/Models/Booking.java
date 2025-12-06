package org.example.uberreviewservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Driver;
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review;

    @ManyToOne
    private driver driver;

    @ManyToOne
    private passenger passenger;

}
