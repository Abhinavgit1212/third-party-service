package com.example.mockmotorapi.model;

import java.time.LocalDate;

public record PaymentInitiationResponse(
        String applicationId,
        String paymentUrl,
        AmountContract amount,
        LocalDate initiateDate
) {}
