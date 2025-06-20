package com.enube.ticket.controller;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) throws Exception {
        this.ticketService = ticketService;
    }
    @PostMapping()
    public void save(@RequestBody TicketDto eventDto) throws Exception {
        ticketService.save(eventDto);
    }

    @PutMapping("/{id}")
    public void updateEvent(@RequestBody TicketDto ticketDto,@PathVariable Long id ) throws Exception {
        ticketService.save(ticketDto,id);
    }


    @GetMapping("/all")
    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    @GetMapping("/byEmail")
    public List<Ticket> getByEmail(@RequestParam String email) {
        return ticketService.findByEmail(email);
    }

    @GetMapping
    public List<Ticket> getAllActive() {
        return ticketService.findAllActive();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) throws Exception {
         return ticketService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) throws Exception {
        ticketService.deleteById(id);
    }



}
