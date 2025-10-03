package com.example.mockmotorapi.model;

import java.util.List;

public record ProposalDetailResponse(
        List<QuoteResponse> quotes,
        ProposalResponse proposal
) {}
