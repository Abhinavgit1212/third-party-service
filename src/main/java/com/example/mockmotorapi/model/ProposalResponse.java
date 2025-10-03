package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.ProposalStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ProposalResponse(
        String proposalId,
        String insuranceType,
        String productId,
        ProposalStatus status,
        List<AssetUWResponse> assetsUWResponse,
        List<MotorAssetAttributes> assets,
        LocalDateTime createdAt
) {}
