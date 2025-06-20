package com.enube.ticket.model.entity;

import com.enube.ticket.model.enums.Status;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ubication")
    private String ubication;
    @Column(name = "number_Of_Tickets")
    private int numberOfTickets;
    @Column(name = "date")
    private String date;
    @Column
    private Status status;

    public Event(String name, String ubication, int numberOfTickets, String date) {
        this.name = name;
        this.ubication = ubication;
        this.numberOfTickets = numberOfTickets;
        this.date = date;
        this.status = Status.ACTIVE;
    }
}
