package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.*;
import com.chainsys.util.MySQLConnection;

public class TransactionDAO {

	public void insertTransaction(Reservations reservation, ParkingSpots parkingSpots, int id)
			throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Transactions (user_id, price, payment_method, transaction_time, payment_status) VALUES (?, ?, '', ?, '')";
		PreparedStatement statement = connection.prepareStatement(query);
		try {
			LocalDateTime start = parseDateTime(reservation.getStartDateTime());
			LocalDateTime end = parseDateTime(reservation.getEndDateTime());
			int price = 0;

			if (start != null && end != null) {
				price = calculatePrice(parkingSpots.getVehicleType(), start, end);
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String transactionTimeFormatted = LocalDateTime.now().format(formatter);

			statement.setInt(1, id);
			statement.setInt(2, price);
			statement.setString(3, transactionTimeFormatted);
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public LocalDateTime parseDateTime(String dateTimeString) {
		if (dateTimeString != null) {
			return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		} else {
			return null;
		}
	}

	public int calculatePrice(String vehicleType, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		Duration duration = Duration.between(startDateTime, endDateTime);
		long hours = duration.toHours();
		int hourlyRate;
		switch (vehicleType) {
		case "Car":
			hourlyRate = 50;
			break;
		case "Bike":
			hourlyRate = 15;
			break;
		case "Truck":
			hourlyRate = 100;
			break;
		default:
			hourlyRate = 50;
			break;
		}
		return (int) (hours * hourlyRate);
	}

	public Transactions readTransactions(Transactions transaction, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT price, transaction_time FROM Transactions WHERE user_id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		try {
			statement.setInt(1, id);
			ResultSet rows = statement.executeQuery();
			if (rows.next()) {
				int price = rows.getInt("price");
				String time = rows.getString("transaction_time");
				transaction.setPrice(price);
				transaction.setTransactionTime(time);
			}
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transaction;
	}

	public void addPaymentMethod(int id, String paymentMethod) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Transactions SET payment_method = ?, payment_status='paid' WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		try {
			statement.setString(1, paymentMethod);
			statement.setInt(2, id);
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Transactions> readTransactions() throws ClassNotFoundException, SQLException {
		List<Transactions> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String read = "SELECT *" + " FROM Transactions";
		PreparedStatement statement = connection.prepareStatement(read);
		try {
			ResultSet rows = statement.executeQuery();
			while (rows.next()) {
				int userId = rows.getInt("user_id");
				int transactionId = rows.getInt("transaction_id");
				int price = rows.getInt("price");
				String paymentMethod = rows.getString("payment_method");
				String transactionTime = rows.getString("transaction_time");
				String paymentStatus = rows.getString("payment_status");
				list.add(new Transactions(userId, transactionId, price, paymentMethod, transactionTime, paymentStatus));
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