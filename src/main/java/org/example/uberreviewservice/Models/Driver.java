package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver extends BaseModel{
    private String name;

    @Column(nullable = false, unique = true)
    private String LicenseNo;

    // 1 : M driver --> bookings
    @OneToMany(mappedBy = "driver",fetch = FetchType.EAGER)
    private List<Booking> Bookings = new ArrayList<>();

}
