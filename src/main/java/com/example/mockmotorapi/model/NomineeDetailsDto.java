package com.example.mockmotorapi.model;

public record NomineeDetailsDto(
        String name,
        String relationship,
        String dateOfBirth,
        String phoneNumber
) {}
