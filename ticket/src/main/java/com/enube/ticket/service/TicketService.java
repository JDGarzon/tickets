package com.enube.ticket.service;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.model.enums.Status;
import com.enube.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;

    public TicketService(TicketRepository ticketRepository,EventService eventService) {
        this.ticketRepository = ticketRepository;
        this.eventService = eventService;
    }

    public void save(TicketDto ticketDto) throws Exception {
        ticketRepository.save(new Ticket(ticketDto.getUsername(),
                ticketDto.getEmail(),
                ticketDto.getReservations(),
                eventService.findById(ticketDto.getEventId())));
    }

    public void save(TicketDto ticketDto,Long id) throws Exception {
        Ticket ticket= findById(id);
        ticket.setReservations(ticketDto.getReservations());
        ticket.setStatus(ticketDto.getStatus());
        ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findAllActive() {
        return ticketRepository.findByStatus(Status.ACTIVE);
    }

    public List<Ticket> findByEmail(String email) {
        return ticketRepository.findByEmail(email);
    }

    public Ticket findById(Long id) throws Exception {
        if (ticketRepository.findById(id).isPresent()){
            return ticketRepository.findById(id).get();
        }else throw new Exception("Ticket not found");
    }

    public void deleteById(Long id) throws Exception{
        Ticket ticket=findById(id);
        ticket.setStatus(Status.CANCELED);
        ticketRepository.save(ticket);
    }

}
