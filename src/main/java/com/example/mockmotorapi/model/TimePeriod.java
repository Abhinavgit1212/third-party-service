package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.TimePeriodUnit;

public record TimePeriod(TimePeriodUnit unit, Integer value) {}
