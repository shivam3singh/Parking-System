package com.parking;

interface CostStrategy {
    double calculateCost(VehicleType type, long entryTimestamp, long exitTimestamp);
}