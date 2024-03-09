package com.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Floor class representing a floor in the parking lot
class Floor {
    private int floorNumber;
    private Map<VehicleType, List<VehicleSpace>> spaces;

    public Floor(int floorNumber, int capacityPerType) {
        this.floorNumber = floorNumber;
        this.spaces = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            spaces.put(type, new ArrayList<>());
            for (int i = 1; i <= capacityPerType; i++) {
                spaces.get(type).add(new VehicleSpace(i, type));
            }
        }
    }

    public boolean isSpaceAvailable(VehicleType type) {
        return spaces.get(type).stream().anyMatch(VehicleSpace::isAvailable);
    }

    public int parkVehicle(Vehicle vehicle, String token, long entryTimestamp) {
        List<VehicleSpace> availableSpaces = spaces.get(vehicle.getType());
        for (VehicleSpace space : availableSpaces) {
            if (space.isAvailable()) {
                space.occupy(token, entryTimestamp);
                return space.getSpaceNumber();
            }
        }
        return -1; // No space available
    }

    public void removeVehicle(String token, long exitTimestamp, ParkingLot parkingLot) {
        for (List<VehicleSpace> spaceList : spaces.values()) {
            for (VehicleSpace space : spaceList) {
                if (!space.isAvailable() && space.getToken().equals(token)) {
                    double fee = parkingLot.calculateParkingFee(space.getType(), space.getEntryTimestamp(), exitTimestamp);
                    System.out.println("Vehicle with token " + token + " removed from space " + space.getSpaceNumber() + ". Parking fee: ₹" + fee);
                    space.vacate();
                    return;
                }
            }
        }
        System.out.println("Vehicle with token " + token + " not found.");
    }
}

