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
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  -- create single table entry
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) -- create tables for each class, generated value (id - table)
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{


    @Column(nullable = false)
    private String content;

    private Double rating;



}
