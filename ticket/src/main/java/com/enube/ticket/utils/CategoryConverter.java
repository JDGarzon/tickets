package com.enube.ticket.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Converter
public class CategoryConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return (attribute != null && !attribute.isEmpty())
                ? String.join(",", attribute)
                : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return (dbData != null && !dbData.isEmpty())
                ? Arrays.asList(dbData.split(","))
                : Collections.emptyList();
    }
}
