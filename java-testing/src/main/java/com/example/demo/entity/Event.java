package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private String location;
    private LocalDateTime Date;
    private Integer capacity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
}
