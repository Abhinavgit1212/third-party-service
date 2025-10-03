package com.example.mockmotorapi.model;

public record MotorExclusionDto(
        String code,
        String remarks,
        Boolean completeExclusion
) {}
