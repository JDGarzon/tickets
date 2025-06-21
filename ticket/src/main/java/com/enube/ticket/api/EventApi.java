package com.enube.ticket.api;

import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/event")
public interface EventApi {

    @PostMapping()
    ResponseEntity<Void> save(@RequestBody EventDto eventDto);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateEvent(@RequestBody EventDto eventDto,@PathVariable Long id );

    @GetMapping("/all")
    ResponseEntity<List<Event>> getAll();

    @GetMapping
    ResponseEntity<List<Event>> getAllActive();

    @GetMapping("/{id}")
    ResponseEntity<Event> getEvent(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable Long id);

    @PostMapping("/load")
    ResponseEntity<Void> preLoadEvents();



}
