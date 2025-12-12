package org.example.uberreviewservice.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class reviewResponseDto {
    private Long id;
    private String content;
    private Double rating;
    private Long booking;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
