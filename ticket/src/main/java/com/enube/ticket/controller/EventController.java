package com.enube.ticket.controller;

import com.enube.ticket.api.EventApi;
import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.service.EventService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController implements EventApi {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void save(EventDto eventDto) {
        eventService.save(eventDto);
    }

    public void updateEvent(EventDto eventDto, Long id ) throws Exception {
        eventService.save(eventDto,id);
    }

    public List<Event> getAll() {
        return eventService.findAll();
    }

    public List<Event> getAllActive() {
        return eventService.findAllActive();
    }

    public Event getEvent(Long id) throws Exception {
         return eventService.findById(id);
    }

    public void deleteEvent(Long id) throws Exception {
        eventService.deleteById(id);
    }

    public void preLoadEvents() {
        eventService.load();
    }



}
