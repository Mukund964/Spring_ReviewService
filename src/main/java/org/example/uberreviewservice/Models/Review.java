package org.example.uberreviewservice.Models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String content;
    private Double rating;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime UpdatedAt;

}
