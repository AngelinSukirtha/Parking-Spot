package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.*;
import com.chainsys.model.*;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistrationLogin registrationLogin = new RegistrationLogin();
	RegistrationLoginImpl registrationLoginImpl = new RegistrationLoginImpl();
	List<RegistrationLogin> list = new ArrayList<RegistrationLogin>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("delete");
		registrationLogin.setEmail(email);

		try {
			registrationLoginImpl.delete(email);
			PrintWriter writer = response.getWriter();
			writer.println(registrationLogin.getEmail() + "delete");
			List<RegistrationLogin> list = registrationLoginImpl.read();
			request.setAttribute("list", list);

			request.getRequestDispatcher("ParkingSpot.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		registrationLogin.setUserName(userName);
		String userPassword = request.getParameter("userPassword");
		registrationLogin.setUserPassword(userPassword);
		String phoneNumber = request.getParameter("phoneNumber");
		registrationLogin.setPhoneNumber(phoneNumber);
		String email = request.getParameter("email");
		registrationLogin.setEmail(email);

		try {
			registrationLoginImpl.update(registrationLogin);
			HttpSession session = request.getSession();
			session.setAttribute("email", email);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			list = registrationLoginImpl.read();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ParkingSpot.jsp");
		dispatcher.forward(request, response);
	}

}