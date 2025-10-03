package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.QuoteState;

public record QuoteDetails(
        String quoteId,
        QuoteState state,
        String currentProposalId,
        Boolean addOnApplicable
) {}
