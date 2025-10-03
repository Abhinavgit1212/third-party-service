package com.example.mockmotorapi.model;

public record AddressDetails(
        String id,
        String line1,
        String line2,
        String pincode,
        String city,
        String state
) {}
