package com.example.mockmotorapi.model;

import java.util.List;

public record AssetUWResponse(
        String assetId,
        String status,
        String specialRemarks,
        List<MotorLoadingDto> loadings,
        List<MotorExclusionDto> exclusions
) {}
