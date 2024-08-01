package com.socoolheeya.travel.system.core.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.socoolheeya.travel.system.core.utils.AssignUtils;

import java.io.IOException;
import java.time.LocalDate;

public class DefaultDateSerializer extends JsonSerializer<LocalDate> {
	@Override
	public void serialize(final LocalDate date, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
		final String dateString = date.format(AssignUtils.DEFAULT_DATE_FORMATTER);
		generator.writeString(dateString);
	}
}
