package com.chainsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.RegistrationLogin;

public interface RegistrationLoginDAO {
	public boolean userRegistration(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException;

	public String userLogin(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException;

	public List<RegistrationLogin> read() throws ClassNotFoundException, SQLException;

	public boolean delete(String email) throws ClassNotFoundException, SQLException;

	public void update(RegistrationLogin registrationLogin) throws ClassNotFoundException, SQLException;

}
