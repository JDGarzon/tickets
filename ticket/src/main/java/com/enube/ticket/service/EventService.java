package com.enube.ticket.service;

import com.enube.ticket.exceptions.NotFoundException;
import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;

import java.util.List;


public interface EventService {

    void save(EventDto eventDto);
    void save(EventDto eventDto,Long id) throws NotFoundException;
    List<Event> findAll();
    List<Event> findAllActive();
    Event findById(Long id) throws NotFoundException;
    void deleteById(Long id) throws NotFoundException;
    void load();

}
