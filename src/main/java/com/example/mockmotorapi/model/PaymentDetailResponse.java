package com.example.mockmotorapi.model;

import java.math.BigDecimal;

public record PaymentDetailResponse(
        BigDecimal basePremium,
        BigDecimal totalDiscount,
        BigDecimal totalLoading,
        BigDecimal gst,
        BigDecimal finalPremium
) {}
