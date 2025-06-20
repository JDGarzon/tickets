package com.enube.ticket.service;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    void save(TicketDto ticketDto) throws Exception;
    void save(TicketDto ticketDto,Long id) throws Exception;
    List<Ticket> findAll();
    List<Ticket> findAllActive();
    List<Ticket> findByEmail(String email);
    Ticket findById(Long id) throws Exception;
    void deleteById(Long id) throws Exception;

}
