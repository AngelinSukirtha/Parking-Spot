package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.model.Reservations;
import com.chainsys.util.MySQLConnection;

public class ReservationDAO {
	public void insertReservation(Reservations reservation, int id) throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Reservations (user_id, number_plate, start_date_time, end_date_time, reservation_status) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.setString(2, reservation.getNumberPlate());
			statement.setString(3, reservation.getStartDateTime());
			statement.setString(4, reservation.getEndDateTime());
			statement.setString(5, "reserved");
			statement.execute();
		}
	}

}
