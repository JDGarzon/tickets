package com.enube.ticket.controller;

import com.enube.ticket.api.TicketApi;
import com.enube.ticket.exceptions.NotEnoughException;
import com.enube.ticket.exceptions.NotFoundException;
import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TicketController implements TicketApi {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<Void> save(TicketDto eventDto) {
        try {
            ticketService.save(eventDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotEnoughException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<Void> updateTicket(TicketDto ticketDto, Long id) {
        try {
            ticketService.update(ticketDto, id);
            return ResponseEntity.noContent().build();
        } catch (NotEnoughException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    public ResponseEntity<List<Ticket>> getByEmail(String email) {
        return ResponseEntity.ok(ticketService.findByEmail(email));
    }

    public ResponseEntity<List<Ticket>> getAllActive() {
        return ResponseEntity.ok(ticketService.findAllActive());
    }

    public ResponseEntity<Ticket> getTicket(Long id) {
        try {
            Ticket ticket = ticketService.findById(id);
            return ResponseEntity.ok(ticket);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    public ResponseEntity<Void> deleteEvent(Long id) {
        try {
            ticketService.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
