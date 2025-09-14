package com.example.demo.mapper;

import com.example.demo.entity.Event;
import com.example.demo.model.request.EventRequest;
import com.example.demo.model.response.EventResponse;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event requestToEntity(EventRequest request) {
        return Event.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .Date(request.getDate())
                .capacity(request.getCapacity())
                .build();
    }

    public EventResponse entityToResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId().toString())
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .date(event.getDate())
                .capacity(event.getCapacity())
                .build();
    }
}
