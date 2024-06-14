package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
			statement.setString(5, "pending");
			statement.execute();
		}
	}

	public List<Reservations> readReservations() throws ClassNotFoundException, SQLException {
		List<Reservations> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String read = "SELECT *" + " FROM Reservations";
		PreparedStatement statement = connection.prepareStatement(read);
		try {
			ResultSet rows = statement.executeQuery();
			while (rows.next()) {
				int userId = rows.getInt("user_id");
				String numberPlate = rows.getString("number_plate");
				String startDateTime = rows.getString("start_date_time");
				String endDateTime = rows.getString("end_date_time");
				String reservationStatus = rows.getString("reservation_status");
				list.add(new Reservations(userId, numberPlate, startDateTime, endDateTime, reservationStatus));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
