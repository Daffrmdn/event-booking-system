package com.example.demo.service.Impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.request.EventRequest;
import com.example.demo.model.response.EventResponse;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EventMapper eventMapper;

    @Override
    public EventResponse createEvent(EventRequest request, String organizerUsername) {
        User organizer = userRepository.findByUsername(organizerUsername)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));

        Event event = eventMapper.requestToEntity(request);
        event.setOrganizer(organizer);

        Event saved = eventRepository.save(event);

        EventResponse response = eventMapper.entityToResponse(saved);
        response.setOrganizerName(organizer.getNama());

        return response;
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> {
                    EventResponse response = eventMapper.entityToResponse(event);
                    response.setOrganizerName(event.getOrganizer().getNama());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
