package com.example.mockmotorapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record QuoteResponse(
        String id,
        String proposalId,
        Boolean selected,
        BigDecimal selectedSumInsured,
        List<PremiumResponse> premiumResponses,
        String pinCode,
        TimePeriod tenure,
        List<AddOnDetail> addOnDetails,
        LocalDateTime createdAt
) {}
