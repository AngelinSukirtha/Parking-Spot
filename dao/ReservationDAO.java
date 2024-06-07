package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.model.Reservations;
import com.chainsys.util.MySQLConnection;

public class ReservationDAO {
	public void insertReservation(Reservations reservation) throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Reservations (user_id, number_plate, start_date, end_date, start_time, end_time, reservation_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, reservation.getUserId());
			statement.setString(2, reservation.getNumberPlate());
			statement.setString(3, reservation.getStartDate());
			statement.setString(4, reservation.getEndDate());
			statement.setString(5, reservation.getStartTime());
			statement.setString(6, reservation.getEndTime());
			statement.setString(7, "reserved");
			statement.executeUpdate();
		}
	}

}
