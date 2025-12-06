package org.example.uberreviewservice.Models;


import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Review extends BaseModel{


    @Column(nullable = false)
    private String content;

    private Double rating;



}
