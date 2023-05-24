package br.edu.ifsp.model.domain;

import java.sql.Date;
import java.util.ArrayList;

public class ParkingSpot {

    int number;
    ParkingLot parkingLot;
    ArrayList<Car> cars;
    Date registerDate;
    String status;
    String block;

    public ParkingSpot() {
    }

    public ParkingSpot(int number, ParkingLot parkingLot, Date registerDate, String status, String block) {
        this.number = number;
        this.parkingLot = parkingLot;
        this.registerDate = registerDate;
        this.status = status;
        this.block = block;
    }

    public ParkingSpot(int number, ParkingLot parkingLot, ArrayList<Car> cars, Date registerDate, String status,
            String block) {
        this.number = number;
        this.parkingLot = parkingLot;
        this.cars = cars;
        this.registerDate = registerDate;
        this.status = status;
        this.block = block;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    
    
}
