package com.enube.ticket.controller;

import com.enube.ticket.api.TicketApi;
import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.service.TicketService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController implements TicketApi {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) throws Exception {
        this.ticketService = ticketService;
    }

    public void save(TicketDto eventDto) throws Exception {
        ticketService.save(eventDto);
    }

    public void updateEvent( TicketDto ticketDto, Long id ) throws Exception {
        ticketService.save(ticketDto,id);
    }

    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    public List<Ticket> getByEmail(String email) {
        return ticketService.findByEmail(email);
    }

    public List<Ticket> getAllActive() {
        return ticketService.findAllActive();
    }

    public Ticket getTicket( Long id) throws Exception {
         return ticketService.findById(id);
    }

    public void deleteEvent(Long id) throws Exception {
        ticketService.deleteById(id);
    }

}
