package br.edu.ifsp.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifsp.model.domain.ParkingLot;
import br.edu.ifsp.model.domain.ParkingSpot;

public class ParkingSpotDao {
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Parkingspot(" +
                "number INT PRIMARY_KEY AUTOINCREMENT UNIQUE NOT NULL" +
                "parkingLotId INT" +
                "registerDate DATE" +
                "status VARCHAR(255)" +
                "block VARCHAR(255)" +
                "parkingLotId REFERENCES Parkinglot(id)";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ParkingSpot parkingSpot) {
        String sql = "INSERT INTO Parkingspot(parkingLotId, " +
                "registerDate, status, block) values(?,?,?,?)";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {

            stmt.setInt(1, parkingSpot.getParkingLot().getId());
            stmt.setDate(2, parkingSpot.getRegisterDate());
            stmt.setString(3, parkingSpot.getStatus());
            stmt.setString(4, parkingSpot.getBlock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ParkingSpot parkingSpot) {
        String sql = "UPDATE FROM Parkingspot SET status=?, block=? " +
                "WHERE number=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, parkingSpot.getStatus());
            stmt.setString(2, parkingSpot.getBlock());
            stmt.setInt(3, parkingSpot.getNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int number) {
        String sql = "DELETE FROM Parkingspot WHERE number=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, number);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ParkingSpot> list() {
        String sql = "SELECT * FROM Parkingspot";
        ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("number");
                int parkingLotId = rs.getInt("parkingLotId");
                ParkingLot parkingLot = new ParkingLot(parkingLotId);
                Date registerDate = rs.getDate("registerDate");
                String status = rs.getString("status");
                String block = rs.getString("block");

                ParkingSpot parkingSpot = new ParkingSpot(number, parkingLot, registerDate,
                 status, block);
                parkingSpots.add(parkingSpot);
            }

            return parkingSpots;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ParkingSpot getByNumber(int number) {
        String sql = "SELECT * FROM Parkingspot WHERE number=?";
        ParkingSpot parkingSpot = null;

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int parkingLotId = rs.getInt("parkingLotId");
                ParkingLot parkingLot = new ParkingLot(parkingLotId);
                Date registerDate = rs.getDate("registerDate");
                String status = rs.getString("status");
                String block = rs.getString("block");
                parkingSpot = new ParkingSpot(number, parkingLot, registerDate, status, block);
            }

            return parkingSpot;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
