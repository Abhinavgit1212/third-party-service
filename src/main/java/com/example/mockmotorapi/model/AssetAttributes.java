package com.example.mockmotorapi.model;

public record AssetAttributes(
        Boolean newAsset,
        Boolean assetAdditionCompleted,
        Boolean selected,
        Boolean confirmed,
        String oldAssetId,
        String baseAssetId,
        Boolean fixed
) {}
