package com.socoolheeya.travel.system.core.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KoreaDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(final LocalDate date, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        final String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        generator.writeString(dateString);
    }
}
