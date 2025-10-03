package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.PaymentState;

import java.util.List;

public record PaymentDetails(
        PaymentState state,
        List<PaymentTransaction> paymentTransactions,
        Boolean paymentDeferred
) {}
