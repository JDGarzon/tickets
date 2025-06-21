package com.enube.ticket.api;

import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/event")
public interface EventApi {

    @PostMapping()
    void save(@RequestBody EventDto eventDto);

    @PutMapping("/{id}")
    void updateEvent(@RequestBody EventDto eventDto,@PathVariable Long id ) throws Exception;

    @GetMapping("/all")
    List<Event> getAll();

    @GetMapping
    List<Event> getAllActive();

    @GetMapping("/{id}")
    Event getEvent(@PathVariable Long id) throws Exception;

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Long id) throws Exception;

    @PostMapping("/load")
    void preLoadEvents();



}
