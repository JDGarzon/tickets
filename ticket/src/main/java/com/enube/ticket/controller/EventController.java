package com.enube.ticket.controller;

import com.enube.ticket.api.EventApi;
import com.enube.ticket.exceptions.NotFoundException;
import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EventController implements EventApi {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public ResponseEntity<Void> save(EventDto eventDto) {
        eventService.save(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> updateEvent(EventDto eventDto, Long id) {
        try {
            eventService.save(eventDto, id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventService.findAll());
    }

    public ResponseEntity<List<Event>> getAllActive() {
        return ResponseEntity.ok(eventService.findAllActive());
    }

    public ResponseEntity<Event> getEvent(Long id) {
        try {
            Event event = eventService.findById(id);
            return ResponseEntity.ok(event);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<Void> deleteEvent(Long id) {
        try {
            eventService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<Void> preLoadEvents() {
        eventService.load();
        return ResponseEntity.ok().build();
    }
}
