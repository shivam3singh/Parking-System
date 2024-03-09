package com.parking;

// Vehicle class representing a vehicle
class Vehicle {
    private String registrationNumber;
    private String color;
    private VehicleType type;
    private long entryTimestamp;

    public Vehicle(String registrationNumber, String color, VehicleType type, long entryTimestamp) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
        this.entryTimestamp = entryTimestamp;
    }
    public Vehicle(String registrationNumber, String color, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }
}
