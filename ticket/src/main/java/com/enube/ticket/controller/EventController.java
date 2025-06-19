package com.enube.ticket.controller;

import com.enube.ticket.dto.EventDto;
import com.enube.ticket.model.Event;
import com.enube.ticket.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping()
    public void save(@RequestBody EventDto eventDto) {
        eventService.save(new Event(eventDto.getName(),eventDto.getUbication(),eventDto.getNumberOfTickets(),eventDto.getDate()));
    }

    @PutMapping("/{id}")
    public void updateEvent(@RequestBody EventDto eventDto,@PathVariable Long id ) {
        eventService.save(new Event(id,eventDto.getName(),eventDto.getUbication(),eventDto.getNumberOfTickets(),eventDto.getDate()));
    }


    @GetMapping
    public List<Event> getAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
         return eventService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
    }



}
