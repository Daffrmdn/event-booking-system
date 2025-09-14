package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse {
    private String id;
    private String eventTitle;
    private String username;
    private Integer quantity;
    private String status;
}
