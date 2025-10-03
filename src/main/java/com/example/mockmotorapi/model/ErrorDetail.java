package com.example.mockmotorapi.model;

public record ErrorDetail(
        String code,
        String message,
        String field
) {}
