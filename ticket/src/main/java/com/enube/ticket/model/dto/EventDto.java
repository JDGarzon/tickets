package com.enube.ticket.model.dto;

import com.enube.ticket.model.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String name;
    private String description;
    private String location;
    private List<String> categories;
    private int numberOfTickets;
    private Date date;
    private Status status;
    private String photo;
}
