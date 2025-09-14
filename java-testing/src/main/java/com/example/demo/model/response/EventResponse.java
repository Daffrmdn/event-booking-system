package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {
    private String id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime date;
    private Integer capacity;
    private String organizerName;
}
