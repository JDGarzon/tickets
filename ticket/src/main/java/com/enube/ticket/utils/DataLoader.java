package com.enube.ticket.utils;

import com.enube.ticket.model.entity.Event;
import com.enube.ticket.repository.EventRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {


    private final EventRepository eventRepository;

    public DataLoader(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/static/data.json");
        if (inputStream == null) {
            throw new FileNotFoundException("JSON file not found");
        }

        TypeReference<List<Event>> typeReference = new TypeReference<>() {};
        List<Event> events = objectMapper.readValue(inputStream, typeReference);

        eventRepository.saveAll(events);
    }
}
