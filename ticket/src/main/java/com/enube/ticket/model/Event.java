package com.enube.ticket.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
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

    public Event(String name, String ubication, int numberOfTickets, String date) {
        this.name = name;
        this.ubication = ubication;
        this.numberOfTickets = numberOfTickets;
        this.date = date;
    }
    
}
