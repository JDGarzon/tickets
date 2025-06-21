package com.enube.ticket.api;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/ticket")
public interface TicketApi {

    @PostMapping()
    ResponseEntity<Void> save(@RequestBody TicketDto eventDto);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateTicket(@RequestBody TicketDto ticketDto,@PathVariable Long id );

    @GetMapping("/all")
    ResponseEntity<List<Ticket>> getAll();

    @GetMapping("/byEmail")
    ResponseEntity<List<Ticket>> getByEmail(@RequestParam String email);

    @GetMapping
    ResponseEntity<List<Ticket>> getAllActive();

    @GetMapping("/{id}")
    ResponseEntity<Ticket> getTicket(@PathVariable Long id) throws Exception;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable Long id) throws Exception;



}
