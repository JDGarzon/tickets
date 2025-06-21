package com.enube.ticket.service.impl;

import com.enube.ticket.model.dto.TicketDto;
import com.enube.ticket.model.entity.Event;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.model.enums.Status;
import com.enube.ticket.repository.TicketRepository;
import com.enube.ticket.service.EventService;
import com.enube.ticket.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;

    public TicketServiceImpl(TicketRepository ticketRepository, EventService eventService) {
        this.ticketRepository = ticketRepository;
        this.eventService = eventService;
    }

    public boolean isReservable(Event event, List<Ticket> tickets, TicketDto toReserve) {
        int totalReservations = tickets.stream()
                .mapToInt(Ticket::getReservations)
                .sum();

        return (event.getNumberOfTickets()-totalReservations)>toReserve.getReservations();
    }

    public void save(TicketDto ticketDto) throws Exception {
        Event event = eventService.findById(ticketDto.getEventId());
        List<Ticket> tickets = ticketRepository.findByEvent(event);
        if (isReservable(event, tickets, ticketDto)) {
            ticketRepository.save(new Ticket(ticketDto.getUsername(),
                    ticketDto.getEmail(),
                    ticketDto.getReservations(),
                    event));
        }else throw new Exception("Not enough tickets available for reservation.");
    }

    public void save(TicketDto ticketDto, Long id) throws Exception {
        Ticket ticket = findById(id);
        ticket.setReservations(ticketDto.getReservations());
        ticket.setStatus(ticketDto.getStatus());

        boolean isLess = ticket.getReservations() > ticketDto.getReservations();
        if (isLess) {
            List<Ticket> tickets = ticketRepository.findByEvent(ticket.getEvent());
            if (!isReservable(ticket.getEvent(), tickets, ticketDto)) {
                throw new Exception("Not enough tickets available for reservation.");
            }
        }

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
