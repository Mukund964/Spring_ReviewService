package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class passenger extends BaseModel {
    @Column(nullable = false)
    private String Name;

    // Booking --> passenger
    @OneToMany(mappedBy = "passenger")
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> Bookings = new ArrayList<>();
}
