package com.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ParkingLot {
    private int totalFloors;
    private int capacityPerFloor;
    private List<Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot(int totalFloors, int capacityPerFloor, CostStrategy costStrategy) {
        this.totalFloors = totalFloors;
        this.capacityPerFloor = capacityPerFloor;
        this.costStrategy = costStrategy;
        initialize();
    }

    private void initialize() {
        floors = new ArrayList<>();
        for (int i = 1; i <= totalFloors; i++) {
            floors.add(new Floor(i, capacityPerFloor));
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        long entryTimestamp = System.currentTimeMillis(); // Current timestamp
        String token = vehicle.getRegistrationNumber();
        for (Floor floor : floors) {
            if (floor.isSpaceAvailable(vehicle.getType())) {
                int spaceNumber = floor.parkVehicle(vehicle, token, entryTimestamp);
                System.out.println("Vehicle with token " + token + " parked at space: " + spaceNumber);
                return token;
            }
        }
        System.out.println("No space available for vehicle with token " + token);
        return null; // No space available
    }

    public void removeVehicle(String token,long exitTimestamp,ParkingLot parkingLot) {

        for (Floor floor : floors) {
            floor.removeVehicle(token, exitTimestamp,parkingLot);
        }
    }

    public double calculateParkingFee(VehicleType type, long entryTimestamp, long exitTimestamp) {
        return costStrategy.calculateCost(type, entryTimestamp, exitTimestamp);
    }

    public boolean isFull() {
        for (Floor floor : floors) {
            for (VehicleType type : VehicleType.values()) {
                if (floor.isSpaceAvailable(type)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
