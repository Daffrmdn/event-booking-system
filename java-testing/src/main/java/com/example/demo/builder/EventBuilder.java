package com.example.demo.builder;

import com.example.demo.entity.Event;
import org.springframework.data.jpa.domain.Specification;

public class EventBuilder {
    public static Specification<Event> hasTitle(String title) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Event> hasLocation(String location) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%");
    }
}
