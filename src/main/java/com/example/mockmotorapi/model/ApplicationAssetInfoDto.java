package com.example.mockmotorapi.model;

import java.util.Map;

public record ApplicationAssetInfoDto(
        String applicationId,
        String id,
        Map<String, AssetAttributes> assetDetails
) {}
