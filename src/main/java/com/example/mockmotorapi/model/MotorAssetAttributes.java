package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.FuelType;
import com.example.mockmotorapi.model.enums.VehicleType;

import java.time.LocalDate;
import java.util.List;

public record MotorAssetAttributes(
        LocalDate registrationDate,
        String rtoCode,
        String registrationNumber,
        String make,
        String model,
        String variant,
        String bodyType,
        List<FuelType> fuelType,
        Integer vehicleAgeInYears,
        VehicleType vehicleType,
        Integer seatingCapacity,
        EngineCapacity engineCapacity,
        Metric<Double> weight,
        LocalDate rcExpiryDate,
        Boolean rcBlackListed,
        Boolean commercialVehicle,
        String rtoLocation
) {}
