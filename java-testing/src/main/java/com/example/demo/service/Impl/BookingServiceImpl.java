package com.example.demo.service.Impl;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.model.request.BookingRequest;
import com.example.demo.model.response.BookingResponse;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponse createBooking(BookingRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepository.findById(UUID.fromString(request.getEventId()))
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (request.getQuantity() > event.getCapacity()) {
            throw new RuntimeException("Not enough tickets available");
        }

        Booking booking = Booking.builder()
                .event(event)
                .user(user)
                .quantity(request.getQuantity())
                .status("CONFIRMED")
                .build();

        event.setCapacity(event.getCapacity() - request.getQuantity());
        eventRepository.save(event);

        Booking saved = bookingRepository.save(booking);
        return bookingMapper.entityToResponse(saved);
    }

    @Override
    public List<BookingResponse> getUserBookings(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findAll().stream()
                .filter(b -> b.getUser().getId().equals(user.getId()))
                .map(bookingMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public String cancelBooking(String bookingId, String username) {
        Booking booking = bookingRepository.findById(UUID.fromString(bookingId))
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getUser().getUsername().equals(username)) {
            throw new RuntimeException("You cannot cancel this booking");
        }

        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);

        // return capacity
        Event event = booking.getEvent();
        event.setCapacity(event.getCapacity() + booking.getQuantity());
        eventRepository.save(event);

        return "Booking cancelled successfully";
    }
}
