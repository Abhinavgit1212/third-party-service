package com.example.mockmotorapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
import java.util.List;

public record GenericResponse<T>(
        int statusCode,
        T data,
        String message,
        String status,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        Collection<ErrorDetail> errors
) {
    public static <T> GenericResponse<T> success(int statusCode, String message, T data) {
        return new GenericResponse<>(statusCode, data, message, "SUCCESS", List.of());
    }

    public static <T> GenericResponse<T> error(int statusCode, String message, Collection<ErrorDetail> errors) {
        return new GenericResponse<>(statusCode, null, message, "ERROR", errors);
    }
}
