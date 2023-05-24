package br.edu.ifsp.model.domain;

import java.util.ArrayList;
import java.util.UUID;

public class ParkingLot {
    int id;
    String name;
    ArrayList<Car> cars;
    ArrayList<ParkingSpot> parkingSpots;
    int maximumCapacity;
    
    public ParkingLot(int id) {
        this.id = id;
    }

    public ParkingLot(int id, String name, int maximumCapacity) {
        this.id = id;
        this.name = name;
        this.maximumCapacity = maximumCapacity;
    }

    public ParkingLot() {
    }

    

    public ParkingLot(int id, String name, ArrayList<Car> cars, ArrayList<ParkingSpot> parkingSpots,
            int maximumCapacity) {
        this.id = id;
        this.name = name;
        this.cars = cars;
        this.parkingSpots = parkingSpots;
        this.maximumCapacity = maximumCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(ArrayList<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    
    
}
