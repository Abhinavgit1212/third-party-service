package com.example.mockmotorapi.model.dto;

public record InitiateApplicationRequest(
        String phoneNumber,
        String registrationNumber
) {}
