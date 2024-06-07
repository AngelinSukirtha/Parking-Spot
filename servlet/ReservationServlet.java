package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.*;
import com.chainsys.dao.*;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Reservations reservation = new Reservations();
	ReservationDAO reservationDAO = new ReservationDAO();

	public ReservationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle GET requests here if needed
		// This method is called when the servlet receives a GET request
		// For this example, let's just redirect to Reservation.html
		response.sendRedirect("Reservation.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle POST requests here
		// This method is called when the servlet receives a POST request

		String numberPlate = request.getParameter("numberPlate");
		reservation.setNumberPlate(numberPlate);
		String startDate = request.getParameter("startDate");
		reservation.setStartDate(startDate);
		String endDate = request.getParameter("endDate");
		reservation.setEndDate(endDate);
		String startTime = request.getParameter("startTime");
		reservation.setStartTime(startTime);
		String endTime = request.getParameter("endTime");
		reservation.setEndTime(endTime);
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(startTime);
		System.out.println(endTime);

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();
		System.out.println(id);

		try {
			reservationDAO.insertReservation(reservation);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// After processing, you may redirect or forward as needed
		response.sendRedirect("Reservation.html");
	}
}
