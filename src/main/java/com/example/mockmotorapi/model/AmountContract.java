package com.example.mockmotorapi.model;

import java.math.BigDecimal;

public record AmountContract(
        BigDecimal value,
        String currency
) {}
