package br.edu.ifsp.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifsp.model.domain.ParkingLot;
import br.edu.ifsp.model.domain.Car;

public class CarDao {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Car("+
            "licensePlate VARCHAR(6) PRIMARY_KEY UNIQUE NOT NULL"+
            "parkingLotId INT"+
            "brand VARCHAR(255)"+
            "color VARCHAR(255)"+
            "owner VARCHAR(255)"+
            "location VARCHAR(3))";

            try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void insert(Car car) {
        String sql = "INSERT INTO Car(parkingLotId, " +
                "brand, color, owner, location) values(?,?,?,?,?)";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {

            stmt.setInt(1, car.getParkingLot().getId());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getColor());
            stmt.setString(4, car.getOwner());
            stmt.setString(5, car.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Car car) {
        String sql = "UPDATE FROM Car SET parkingLotId=?, brand=? " +
                "color=?, owner=?, location=? WHERE licensPlate=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, car.getParkingLot().getId());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getColor());
            stmt.setString(4, car.getOwner());
            stmt.setString(5, car.getLocation());
            stmt.setString(6, car.getLicensePlate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String licensePlate) {
        String sql = "DELETE FROM Car WHERE licensePlate=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, licensePlate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> list() {
        String sql = "SELECT * FROM Car";
        ArrayList<Car> cars = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String licensePlate = rs.getString("licensePlate");
                int parkingLotId = rs.getInt("parkingLotId");
                ParkingLot parkingLot = new ParkingLot(parkingLotId);
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String owner = rs.getString("owner");
                String location = rs.getString("location");

                Car car = new Car(licensePlate, parkingLot, brand,
                 color, owner, location);
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Car getByLicensePlate(String licensePlate) {
        String sql = "SELECT * FROM Car WHERE licensePlate=?";
        Car car = null;

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, licensePlate);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int parkingLotId = rs.getInt("parkingLotId");
                ParkingLot parkingLot = new ParkingLot(parkingLotId);
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String owner = rs.getString("owner");
                String location = rs.getString("location");
                car = new Car(licensePlate, parkingLot, brand,
                 color, owner, location);
            }

            return car;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
