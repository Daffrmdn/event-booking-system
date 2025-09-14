// BookingController.java
package com.example.demo.controller;

import com.example.demo.model.request.BookingRequest;
import com.example.demo.model.response.BookingResponse;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest request, Authentication auth) {
        return ResponseEntity.ok(bookingService.createBooking(request, auth.getName()));
    }
    @GetMapping
    public ResponseEntity<List<BookingResponse>> getUserBookings(Authentication auth) {
        return ResponseEntity.ok(bookingService.getUserBookings(auth.getName()));
    }
    @PostMapping("/{id}/cancel")
    public ResponseEntity<String> cancelBooking(@PathVariable String id, Authentication auth) {
        return ResponseEntity.ok(bookingService.cancelBooking(id, auth.getName()));
    }
}
