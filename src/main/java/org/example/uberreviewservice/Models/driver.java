package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class driver extends BaseModel{
    private String name;

    @Column(nullable = false, unique = true)
    private String LicenseNo;

    // 1 : M driver --> bookings
    @OneToMany(mappedBy = "driver")
    private List<Booking> Bookings = new ArrayList<>();

}
