package com.enube.ticket.service;

import com.enube.ticket.model.dto.EventDto;
import com.enube.ticket.model.entity.Event;

import java.util.List;


public interface EventService {

    void save(EventDto eventDto);
    void save(EventDto eventDto,Long id) throws Exception;
    List<Event> findAll();
    List<Event> findAllActive();
    Event findById(Long id) throws Exception;
    void deleteById(Long id) throws Exception;

}
