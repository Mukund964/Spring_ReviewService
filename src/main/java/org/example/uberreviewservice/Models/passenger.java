package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class passenger extends BaseModel {
    @Column(nullable = false)
    private String Name;
}
