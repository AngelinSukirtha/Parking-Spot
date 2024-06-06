package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.model.*;
import com.chainsys.util.*;

public class ParkingSpotsDAO {

	public void addParkingSpot(int userId, String locationName, String address, int spotNumber, String spotStatus)
			throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Parking_Spots (user_id, location_name, address, spot_number, spot_status) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, userId);
		statement.setString(2, locationName);
		statement.setString(3, address);
		statement.setInt(4, spotNumber);
		statement.setString(5, spotStatus);
		statement.executeUpdate();
	}

	public List<ParkingSpots> getAllParkingSpots() throws SQLException, ClassNotFoundException {
		List<ParkingSpots> parkingSpots = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM Parking_Spots";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int userId = resultSet.getInt("user_id");
			int locationId = resultSet.getInt("location_id");
			String locationName = resultSet.getString("location_name");
			String address = resultSet.getString("address");
			String spotNumber = resultSet.getString("spot_number");
			String spotStatus = resultSet.getString("spot_status");
			parkingSpots.add(new ParkingSpots(userId, locationId, locationName, address, spotNumber, spotStatus));
		}
		return parkingSpots;
	}

	public void updateSpotStatus(int locationId, String spotStatus) throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Parking_Spots SET spot_status = ? WHERE location_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, spotStatus);
		statement.setInt(2, locationId);
		statement.executeUpdate();
	}

	public void addLocationName(ParkingSpots parkingSpots, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Parking_Spots (user_id, location_name, address, spot_number, spot_status) VALUES (?, ?, '', 0, '')";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2, parkingSpots.getLocationName());
		statement.execute();
	}

	public void addAddress(ParkingSpots parkingSpots, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Parking_Spots SET address = ? WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, parkingSpots.getAddress());
		statement.setInt(2, id);
		statement.executeUpdate();
	}

	public void addSpotNumber(ParkingSpots parkingSpots, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Parking_Spots SET spot_number = ? WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, parkingSpots.getSpotNumber());
		statement.setInt(2, id);
		statement.executeUpdate();
	}

}
