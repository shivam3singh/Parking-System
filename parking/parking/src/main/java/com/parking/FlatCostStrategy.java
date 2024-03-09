package com.parking;

import java.util.HashMap;
import java.util.Map;

class FlatCostStrategy implements CostStrategy {
    private Map<VehicleType, Double> hourlyRates;

    public FlatCostStrategy() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.CAR, 20.0);
        hourlyRates.put(VehicleType.SPORTS_CAR, 20.0);
        hourlyRates.put(VehicleType.TRUCK, 30.0);
        hourlyRates.put(VehicleType.BUS, 30.0);
    }

    @Override
    public double calculateCost(VehicleType type, long entryTimestamp, long exitTimestamp) {
        long hoursParked = (exitTimestamp - entryTimestamp) / (60 * 60 * 1000); // Convert milliseconds to hours
        return hourlyRates.get(type) * hoursParked;
    }
}