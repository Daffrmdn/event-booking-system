package com.example.demo.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventRequest {
    private String title;
    private String description;
    private String location;
    private LocalDateTime date;
    private Integer capacity;
    private Double price;
}
