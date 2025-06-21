package com.enube.ticket.service;

import com.enube.ticket.exceptions.NotEnoughException;
import com.enube.ticket.exceptions.NotFoundException;
import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    void save(TicketDto ticketDto) throws NotEnoughException,NotFoundException;
    void update(TicketDto ticketDto,Long id) throws NotEnoughException,NotFoundException;
    List<Ticket> findAll();
    List<Ticket> findAllActive();
    List<Ticket> findByEmail(String email);
    Ticket findById(Long id) throws NotFoundException;
    void deleteById(Long id) throws NotFoundException;

}
