package com.enube.ticket.controller;

import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.service.EventService;
import org.springframework.data.crossstore.ChangeSetPersister;
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
        eventService.save(eventDto);
    }

    @PutMapping("/{id}")
    public void updateEvent(@RequestBody EventDto eventDto,@PathVariable Long id ) throws Exception {
        eventService.save(eventDto,id);
    }


    @GetMapping("/all")
    public List<Event> getAll() {
        return eventService.findAll();
    }
    @GetMapping
    public List<Event> getAllActive() {
        return eventService.findAllActive();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) throws Exception {
         return eventService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) throws Exception {
        eventService.deleteById(id);
    }



}
