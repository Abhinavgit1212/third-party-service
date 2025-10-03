package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.Sex;

import java.time.LocalDate;

public record ProposerDetailsDto(
        String name,
        LocalDate dob,
        Sex gender,
        String phoneNumber,
        String email,
        AddressDetails addressDetails
) {}
