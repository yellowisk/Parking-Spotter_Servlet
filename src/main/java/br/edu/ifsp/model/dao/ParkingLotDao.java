package br.edu.ifsp.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifsp.model.domain.ParkingLot;

public class ParkingLotDao {
    
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Parkinglot("+
            "id INT PRIMARY_KEY AUTOINCREMENT UNIQUE NOT NULL"+
            "name VARCHAR(255)"+
            "maximumCapacity INT)";

            try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void insert(ParkingLot parkingLot){
        String sql = "INSERT INTO parkinglot(name, maximumcapacity) values(?,?)";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, parkingLot.getName());
            stmt.setInt(2, parkingLot.getMaximumCapacity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ParkingLot parkingLot){
        String sql = "UPDATE FROM parkinglot SET name=?, maximumCapacity=? "+
        "WHERE id=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, parkingLot.getName());
            stmt.setInt(2, parkingLot.getMaximumCapacity());
            stmt.setInt(3, parkingLot.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM parkinglot WHERE id=?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ParkingLot> list(){
        String sql = "SELECT * FROM parkinglot";
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int maximumCapacity = rs.getInt("maximumCapacity");

                ParkingLot parkingLot = new ParkingLot(id, name, maximumCapacity);
                parkingLots.add(parkingLot);
            }

            return parkingLots;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ParkingLot getById(int id){
        String sql = "SELECT * FROM parkinglot WHERE id=?";
        ParkingLot parkingLot = null;

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int maximumCapacity = rs.getInt("maximumCapacity");
                parkingLot = new ParkingLot(id, name, maximumCapacity);
            }

            return parkingLot;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
