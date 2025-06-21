package com.enube.ticket.repository;

import com.enube.ticket.model.entity.Event;
import com.enube.ticket.model.entity.Ticket;
import com.enube.ticket.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findByStatus(Status status);
    List<Ticket> findByEmail(String email);
    List<Ticket> findByEvent(Event event);

}
