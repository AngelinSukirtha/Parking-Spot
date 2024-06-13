package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.model.*;
import com.chainsys.util.*;

public class ParkingSpotsDAO {

	public void addLocationName(ParkingSpots parkingSpots, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Parking_Spots (user_id, location_name, address, vehicle_type, spot_number, spot_status) VALUES (?, ?, '', '', 0, '')";
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

	public void addSpotNumber(int id, String vehicleType, String spotNumber)
			throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Parking_Spots SET vehicle_type=?, spot_number = ?, spot_status='occupied' WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, vehicleType);
		statement.setString(2, spotNumber);
		statement.setInt(3, id);
		statement.executeUpdate();
	}

}
