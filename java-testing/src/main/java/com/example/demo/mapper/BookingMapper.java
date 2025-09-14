package com.example.demo.mapper;

import com.example.demo.entity.Booking;
import com.example.demo.model.response.BookingResponse;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponse entityToResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId().toString())
                .eventTitle(booking.getEvent().getTitle())
                .username(booking.getUser().getUsername())
                .quantity(booking.getQuantity())
                .status(booking.getStatus())
                .build();
    }
}
