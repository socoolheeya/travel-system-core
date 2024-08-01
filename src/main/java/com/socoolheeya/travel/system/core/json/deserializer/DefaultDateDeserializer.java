package com.socoolheeya.travel.system.core.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.socoolheeya.travel.system.core.utils.AssignUtils;

import java.io.IOException;
import java.time.LocalDate;

public class DefaultDateDeserializer extends JsonDeserializer<LocalDate> {
	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
			ObjectCodec oc = jp.getCodec();
			TextNode node = oc.readTree(jp);
			String dateString = node.textValue();
			return LocalDate.parse(dateString, AssignUtils.DEFAULT_DATE_FORMATTER);
	}
}
