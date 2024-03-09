package com.parking;

// VehicleSpace class representing a parking space for a vehicle
class VehicleSpace {
    private int spaceNumber;
    private boolean availability;
    private VehicleType type;
    private String token;
    private long entryTimestamp;

    public VehicleSpace(int spaceNumber, VehicleType type) {
        this.spaceNumber = spaceNumber;
        this.availability = true;
        this.type = type;
        this.token = null;
        this.entryTimestamp = 0;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void occupy(String token, long entryTimestamp) {
        availability = false;
        this.token = token;
        this.entryTimestamp = entryTimestamp;
    }

    public void vacate() {
        availability = true;
        this.token = null;
        this.entryTimestamp = 0;
    }

    public VehicleType getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }
}
