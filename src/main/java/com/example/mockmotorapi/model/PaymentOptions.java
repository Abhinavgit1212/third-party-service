package com.example.mockmotorapi.model;

public record PaymentOptions(
        PaymentDetailResponse monthly,
        PaymentDetailResponse yearly
) {}
