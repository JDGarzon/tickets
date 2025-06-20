package com.enube.ticket.model.dto;

import com.enube.ticket.model.enums.Status;
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
    private Status status;
}
