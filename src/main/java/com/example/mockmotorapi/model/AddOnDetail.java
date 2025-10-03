package com.example.mockmotorapi.model;

import java.math.BigDecimal;

public record AddOnDetail(
        String id,
        String title,
        String description,
        BigDecimal totalAmount,
        Boolean opted,
        PaymentDetailResponse paymentDetails
) {}
