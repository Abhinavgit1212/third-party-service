package com.example.mockmotorapi.model.dto;

import com.example.mockmotorapi.model.MotorAssetAttributes;
import com.example.mockmotorapi.model.QuoteResponse;
import com.example.mockmotorapi.model.enums.ApplicationStatus;

import java.time.LocalDateTime;
import java.util.List;

public record InitiateApplicationResponse(
        String applicationId,
        ApplicationStatus applicationStatus,
        MotorAssetAttributes vehicleDetails,
        List<QuoteResponse> quotes,
        LocalDateTime expiresAt
) {}
