package com.restaurants.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonLocalDateConverter {

    public static class UserSettingSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate ldt, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(DateTimeUtil.toString(ldt));
        }

        @Override
        public Class<LocalDate> handledType() {
            return LocalDate.class;
        }
    }

    public static class UserSettingDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
            return DateTimeUtil.parseLocalDate(jp.getText());
        }

        @Override
        public Class<LocalDateTime> handledType() {
            return LocalDateTime.class;
        }
    }

    public static class RestaurantSettingSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate ldt, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(DateTimeUtil.toString(ldt));
        }

        @Override
        public Class<LocalDate> handledType() {
            return LocalDate.class;
        }
    }

    public static class RestaurantSettingDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
            return DateTimeUtil.parseLocalDate(jp.getText());
        }

        @Override
        public Class<LocalDate> handledType() {
            return LocalDate.class;
        }
    }
}
