package com.parking;

import java.util.UUID;

public class Main {
    public static ParkingLot parkingLot;

    public static void main(String[] args) {
        // Initialize the parking lot
        CostStrategy costStrategy = new FlatCostStrategy();
        ParkingLot parkingLot = new ParkingLot(1, 2, costStrategy);

        // Add vehicles to the parking lot
        String token1 = parkingLot.parkVehicle(new Vehicle("ABC123", "Red", VehicleType.CAR));
        if (token1 != null) {
            System.out.println("Car parked. Token: " + token1);
        } else {
            System.out.println("Failed to park the car.");
        }

        String token2 = parkingLot.parkVehicle(new Vehicle("XYZ456", "Blue", VehicleType.CAR));
        if (token2 != null) {
            System.out.println("Car parked. Token: " + token2);
        } else {
            System.out.println("Failed to park the car.");
        }

        // Try to park another vehicle when the parking lot is full
        if (parkingLot.isFull()) {
            System.out.println("Parking lot is full.");
        } else {
            String token3 = parkingLot.parkVehicle(new Vehicle("DEF789", "Green", VehicleType.CAR));
            if (token3 != null) {
                System.out.println("Car parked. Token: " + token3);
            } else {
                System.out.println("Failed to park the car.");
            }
        }
        // Remove a vehicle from the parking lot using token ID and timestamp
        // Note: Replace the timestamp value with the actual exit timestamp
        parkingLot.removeVehicle("XYZ456", System.currentTimeMillis(),parkingLot);

    }
}
