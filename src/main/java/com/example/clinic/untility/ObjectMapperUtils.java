package com.example.clinic.untility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class ObjectMapperUtils {
    private final static ObjectMapper MAPPER = new ObjectMapper();
    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String convertObjectToJSON(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e ) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertJSONToObject(String json, Class<T> classType) throws IOException {
        return MAPPER.readValue(json, classType);
    }

    public static <T> T convertJSONToObject(String json, TypeReference<T> classType) throws IOException {
        return MAPPER.readValue(json, classType);
    }

    public static Map convertObjectToMap(Object value) throws IOException {
        return MAPPER.convertValue(value, Map.class);
    }
}
