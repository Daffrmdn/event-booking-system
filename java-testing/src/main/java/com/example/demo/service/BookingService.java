// BookingService.java
package com.example.demo.service;

import com.example.demo.model.request.BookingRequest;
import com.example.demo.model.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request, String username);
    List<BookingResponse> getUserBookings(String username);
    String cancelBooking(String bookingId, String username);
}
