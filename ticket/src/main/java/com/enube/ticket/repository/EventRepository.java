package com.enube.ticket.repository;


import com.enube.ticket.model.entity.Event;
import com.enube.ticket.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByStatus(Status status);
}
