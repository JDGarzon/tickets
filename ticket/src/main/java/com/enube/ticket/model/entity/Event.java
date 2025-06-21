package com.enube.ticket.model.entity;

import com.enube.ticket.model.enums.Status;
import com.enube.ticket.utils.CategoryConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


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

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "categories")
    @Convert(converter = CategoryConverter.class)
    private List<String> categories;

    @Column(name = "number_Of_Tickets")
    private int numberOfTickets;

    @Column(name = "date")
    private Date date;

    @Column(name = "photo")
    private String photo;

    @Column
    private Status status;

    public Event(String name, String description, int numberOfTickets, Date date,List<String> categories,String photo,Status status,String location) {
        this.name = name;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.date = date;
        this.status = status;
        this.categories = categories;
        this.photo = photo;
        this.location = location;
    }
}
