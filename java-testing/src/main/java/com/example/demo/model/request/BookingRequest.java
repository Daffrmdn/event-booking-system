// BookingRequest.java
package com.example.demo.model.request;

import lombok.Data;

@Data
public class BookingRequest {
    private String eventId;
    private Integer quantity;
}
