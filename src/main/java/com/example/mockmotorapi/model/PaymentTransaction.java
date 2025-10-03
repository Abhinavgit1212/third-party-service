package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.PaymentState;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentTransaction(
        PaymentState state,
        String quoteId,
        String paymentReferenceId,
        LocalDateTime paymentCompletionTimeInIst,
        BigDecimal paymentAmount,
        String instrumentReferenceId
) {}
