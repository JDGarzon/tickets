package com.enube.ticket.model.dto;

import com.enube.ticket.model.enums.Status;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String username;
    private String email;
    private int reservations;
    private Status status;
    private Long eventId;

}
