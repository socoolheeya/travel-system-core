package com.socoolheeya.travel.system.core.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class KoreanDateStartDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec oc = jp.getCodec();
        TextNode node = oc.readTree(jp);
        String dateString = node.textValue();
        if("0000-00-00".equals(dateString)) {
            return LocalDate.now(ZoneId.of("Asia/Seoul"));
        }
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA));
    }
}
