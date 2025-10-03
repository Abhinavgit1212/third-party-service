package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.PolicyStatus;

public record PolicyApplicationData(
        PolicyStatus state,
        String policyId
) {}
