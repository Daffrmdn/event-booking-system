// EventController.java
package com.example.demo.controller;

import com.example.demo.model.request.EventRequest;
import com.example.demo.model.response.EventResponse;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request, Authentication auth) {
        String username = auth.getName();
        return ResponseEntity.ok(eventService.createEvent(request, username));
    }
    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
