package br.edu.ifsp.model.domain;

import java.util.UUID;

public class Car {
    String licensePlate;
    ParkingLot parkingLot;
    String brand;
    String color;
    String owner;
    String location;

    public Car() {
    }

    public Car(String licensePlate, ParkingLot parkingLot, String brand, String color, String owner,
            String location) {
        this.licensePlate = licensePlate;
        this.parkingLot = parkingLot;
        this.brand = brand;
        this.color = color;
        this.owner = owner;
        this.location = location;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

}
