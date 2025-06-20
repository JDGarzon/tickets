package com.enube.ticket.model.entity;

import com.enube.ticket.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tickets",
       indexes = {
        @Index(name = "idx_email", columnList = "email")
       }
)
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "reservations")
    private int reservations;
    @Column(name = "status")
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Ticket(String username, String email, int reservations, Event event) {
        this.username = username;
        this.email = email;
        this.reservations = reservations;
        this.status = Status.ACTIVE;
        this.event = event;
    }

}
