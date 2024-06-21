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
		String query = "INSERT INTO Reservations (user_id, reservation_id, number_plate, start_date_time, end_date_time, reservation_status, is_active) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.setInt(2, reservation.getReservationId());
			statement.setString(3, reservation.getNumberPlate());
			statement.setString(4, reservation.getStartDateTime());
			statement.setString(5, reservation.getEndDateTime());
			statement.setString(6, "pending");
			statement.setBoolean(7, reservation.getIsActive());
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
				int reservationId = rows.getInt("reservation_id");
				String numberPlate = rows.getString("number_plate");
				String startDateTime = rows.getString("start_date_time");
				String endDateTime = rows.getString("end_date_time");
				String reservationStatus = rows.getString("reservation_status");
				boolean isActive = rows.getBoolean("is_active");
				list.add(new Reservations(userId, reservationId, numberPlate, startDateTime, endDateTime,
						reservationStatus, isActive));
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

	public Reservations readReservation(Reservations reservation, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String read = "SELECT reservation_id FROM Reservations WHERE user_id=? and is_active=true";
		PreparedStatement statement = connection.prepareStatement(read);
		try {
			statement.setInt(1, id);
			ResultSet rows = statement.executeQuery();
			if (rows.next()) {
				int reservationId = rows.getInt("reservation_id");
				reservation.setReservationId(reservationId);
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
		return reservation;
	}

	public void updateReservationStatus(Reservations reservation) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Reservations SET reservation_status=? WHERE reservation_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		try {
			statement.setString(1, reservation.getReservationStatus());
			statement.setInt(2, reservation.getReservationId());
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateIsActive(Reservations reservation) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Reservations SET is_active=? WHERE reservation_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		try {
			statement.setBoolean(1, reservation.getIsActive());
			statement.setInt(2, reservation.getReservationId());
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
