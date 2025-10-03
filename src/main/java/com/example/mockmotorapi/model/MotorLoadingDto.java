package com.example.mockmotorapi.model;

import java.math.BigDecimal;

public record MotorLoadingDto(
        String type,
        BigDecimal loadingValue,
        String remarks
) {}
