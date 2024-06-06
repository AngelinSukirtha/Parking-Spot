package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.model.*;
import com.chainsys.util.*;

public class RegistrationLoginImpl implements RegistrationLoginDAO {

	public boolean userRegistration(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT * FROM Users WHERE user_name=? AND user_password=? AND phone_number=? AND email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, registrationLogin.getUserName());
		preparedStatement.setString(2, registrationLogin.getUserPassword());
		preparedStatement.setString(3, registrationLogin.getPhoneNumber());
		preparedStatement.setString(4, registrationLogin.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (!resultSet.next()) {
			String insert = "INSERT INTO Users (user_name,user_password,phone_number,email) VALUES (?, ?, ?, ?)";
			PreparedStatement p = connection.prepareStatement(insert);
			p.setString(1, registrationLogin.getUserName());
			p.setString(2, registrationLogin.getUserPassword());
			p.setString(3, registrationLogin.getPhoneNumber());
			p.setString(4, registrationLogin.getEmail());
			p.execute();
			System.out.println("Registered  successfull");
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return true;
	}

	public String userLogin(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException {
		String email = null;
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT email FROM  Users  WHERE email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, registrationLogin.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			email = resultSet.getString(1);
		}
		System.out.println(resultSet + "retrieved");
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return email;
	}

	public List<RegistrationLogin> read() throws ClassNotFoundException, SQLException {
		List<RegistrationLogin> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String read = "SELECT * FROM Users";
		PreparedStatement p = connection.prepareStatement(read);
		try {
			System.out.println(p);
			ResultSet rows = p.executeQuery();
			while (rows.next()) {
				int userId = rows.getInt("user_id");
				String userName = rows.getString("user_name");
				String userPassword = rows.getString("user_password");
				String phoneNumber = rows.getString("phone_number");
				String email = rows.getString("email");
				list.add(new RegistrationLogin(userId, userName, userPassword, phoneNumber, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean delete(String email) throws ClassNotFoundException, SQLException {
		boolean rowDeleted;
		String delete = "DELETE FROM Users WHERE email=?";
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement p = connection.prepareStatement(delete);) {
			p.setString(1, email);
			rowDeleted = p.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public void update(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException {
		String update = "UPDATE Users SET user_name=?, user_password=?, phone_number=? WHERE email=?";
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement p = connection.prepareStatement(update)) {
			p.setString(1, registrationLogin.getUserName());
			p.setString(2, registrationLogin.getUserPassword());
			p.setString(3, registrationLogin.getPhoneNumber());
			p.setString(4, registrationLogin.getEmail());
			int rows = p.executeUpdate();
			System.out.println(rows + " rows updated");
		}
	}

//	public  void getUserById(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException {
//		Connection connection = MySQLConnection.getConnection();
//		String query = "SELECT * FROM Users WHERE id=?";
//		PreparedStatement p = connection.prepareStatement(query);
//	    p.setInt(1, registrationLogin.getUserId());
//	    ResultSet rows = p.executeQuery();	        
//	        if (rows.next()) {
//	        	registrationLogin.setId(registrationLogin.getInt("id"));
//	        	registrationLogin.setUserName(registrationLogin.getString("user_name"));
//	            registrationLogin.setUserPassword(registrationLogin.getString("user_password"));
//	            registrationLogin.setPhoneNumber(registrationLogin.getString("phone_number"));
//	            registrationLogin.setEmail(registrationLogin.getString("email"));
//	      
//	        }
//	    }return user;
//}

}
