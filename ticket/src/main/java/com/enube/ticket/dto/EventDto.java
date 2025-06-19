package com.enube.ticket.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String name;
    private String ubication;
    private int numberOfTickets;
    private String date;
}
