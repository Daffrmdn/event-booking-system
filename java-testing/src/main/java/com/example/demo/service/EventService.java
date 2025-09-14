// EventService.java
package com.example.demo.service;

import com.example.demo.model.request.EventRequest;
import com.example.demo.model.response.EventResponse;
import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest request, String organizerUsername);
    List<EventResponse> getAllEvents();
}
