package com.enube.ticket.service;

import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.model.enums.Status;
import com.enube.ticket.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(EventDto eventDto) {
        eventRepository.save(new Event(eventDto.getName(),eventDto.getUbication(),eventDto.getNumberOfTickets(),eventDto.getDate()));
    }
    public void save(EventDto eventDto,Long id) throws Exception {
        Event event = findById(id);
        event.setName(eventDto.getName());
        event.setDate(eventDto.getDate());
        event.setUbication(eventDto.getUbication());
        event.setNumberOfTickets(eventDto.getNumberOfTickets());
        event.setStatus(eventDto.getStatus());
        eventRepository.save(event);
    }


    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public List<Event> findAllActive() {
        return eventRepository.findByStatus(Status.ACTIVE);
    }

    public Event findById(Long id) throws Exception {
        if (eventRepository.findById(id).isPresent()){
            return eventRepository.findById(id).get();
        }else throw new Exception("Event not found");
    }

    public void deleteById(Long id) throws Exception{
        Event event=findById(id);
        event.setStatus(Status.CANCELED);
        eventRepository.save(event);
    }

}
