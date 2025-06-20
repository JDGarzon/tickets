package com.enube.ticket.api;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/ticket")
public interface TicketApi {

    @PostMapping()
    void save(@RequestBody TicketDto eventDto) throws Exception ;

    @PutMapping("/{id}")
    void updateEvent(@RequestBody TicketDto ticketDto,@PathVariable Long id ) throws Exception;

    @GetMapping("/all")
    List<Ticket> getAll();

    @GetMapping("/byEmail")
    List<Ticket> getByEmail(@RequestParam String email);

    @GetMapping
    List<Ticket> getAllActive();

    @GetMapping("/{id}")
    Ticket getTicket(@PathVariable Long id) throws Exception;

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Long id) throws Exception;



}
