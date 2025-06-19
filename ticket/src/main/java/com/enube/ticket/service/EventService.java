package com.enube.ticket.service;

import com.enube.ticket.model.Event;
import com.enube.ticket.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }


    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(Long id) {
        if (eventRepository.findById(id).isPresent()){
            return eventRepository.findById(id).get();
        }else return null;
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

}
