package com.example.mockmotorapi.model;

import java.math.BigDecimal;

public record PremiumResponse(
        BigDecimal deductible,
        BigDecimal sumInsured,
        PaymentOptions paymentDetails
) {}
