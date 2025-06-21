package com.enube.ticket.service.impl;

import com.enube.ticket.exceptions.NotFoundException;
import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.model.enums.Status;
import com.enube.ticket.repository.EventRepository;
import com.enube.ticket.service.EventService;
import com.enube.ticket.utils.DataLoader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(EventDto eventDto) {
        eventRepository.save(new Event(eventDto.getName(),eventDto.getDescription(),
                eventDto.getNumberOfTickets(),eventDto.getDate(),eventDto.getCategories(),
                eventDto.getPhoto(),Status.ACTIVE,eventDto.getLocation()));
    }

    public void save(EventDto eventDto,Long id) throws NotFoundException {
        Event event = findById(id);
        event.setName(eventDto.getName());
        event.setDate(eventDto.getDate());
        event.setDescription(eventDto.getDescription());
        event.setNumberOfTickets(eventDto.getNumberOfTickets());
        event.setStatus(eventDto.getStatus());
        event.setCategories(eventDto.getCategories());
        event.setPhoto(eventDto.getPhoto());
        eventRepository.save(event);
    }


    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public List<Event> findAllActive() {
        return eventRepository.findByStatus(Status.ACTIVE);
    }

    public Event findById(Long id) throws NotFoundException {
        if (eventRepository.findById(id).isPresent()){
            return eventRepository.findById(id).get();
        }else throw new NotFoundException("Event not found");
    }

    public void deleteById(Long id) throws NotFoundException{
        Event event=findById(id);
        event.setStatus(Status.CANCELED);
        eventRepository.save(event);
    }


    public void load() {
        DataLoader dataLoader= new DataLoader(eventRepository);
        try {
            dataLoader.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
