package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.chainsys.model.*;
import com.chainsys.util.MySQLConnection;

public class TransactionDAO {

	private static final int HOURLY_RATE = 50;

	public void insertTransaction(Reservations reservation, Transactions transaction, int id)
			throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		String query = "INSERT INTO Transactions (user_id, price, payment_method, transaction_time, payment_status) VALUES (?, ?, '', ?, '')";
		PreparedStatement statement = connection.prepareStatement(query);

		LocalDateTime start = parseDateTime(reservation.getStartDateTime());
		LocalDateTime end = parseDateTime(reservation.getEndDateTime());
		int price = 0;

		if (start != null && end != null) {
			price = calculatePrice(start, end);
			System.out.println("Calculated price: " + price);
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String transactionTimeFormatted = LocalDateTime.now().format(formatter);

		statement.setInt(1, id);
		statement.setInt(2, price);
		statement.setString(3, transactionTimeFormatted);
		statement.executeUpdate();
	}

	private LocalDateTime parseDateTime(String dateTimeString) {
		if (dateTimeString != null) {
			return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		} else {
			return null;
		}
	}

	private int calculatePrice(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		if (startDateTime != null && endDateTime != null) {
			Duration duration = Duration.between(startDateTime, endDateTime);
			long hours = duration.toHours();
			return (int) (hours * HOURLY_RATE);
		} else {
			return 0;
		}
	}

	public Transactions readTransactions(Transactions transaction, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT price, transaction_time FROM Transactions WHERE user_id=?";
		PreparedStatement p = connection.prepareStatement(query);
		p.setInt(1, id);
		ResultSet rows = p.executeQuery();
		if (rows.next()) {
			int price = rows.getInt("price");
			String time = rows.getString("transaction_time");
			transaction.setPrice(price);
			transaction.setTransactionTime(time);
			System.out.println(price);
			System.out.println(time);
		}
		return transaction;
	}

	public void addPaymentMethod(int id, String paymentMethod) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "UPDATE Transactions SET payment_method = ?, payment_status='paid' WHERE user_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, paymentMethod);
		statement.setInt(2, id);
		statement.executeUpdate();
	}

}
