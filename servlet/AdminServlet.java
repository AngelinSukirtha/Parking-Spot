package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.*;
import com.chainsys.model.*;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistrationLogin registrationLogin = new RegistrationLogin();
	Reservations reservation = new Reservations();
	ParkingSpots parkingSpots = new ParkingSpots();
	Transactions transactions = new Transactions();
	RegistrationLoginImpl registrationLoginImpl = new RegistrationLoginImpl();
	ReservationDAO reservationDAO = new ReservationDAO();
	ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();
	TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		registrationLogin.setUserName(userName);
		registrationLogin.setUserPassword(userPassword);
		registrationLogin.setPhoneNumber(phoneNumber);
		registrationLogin.setEmail(email);

		String numberPlate = request.getParameter("numberPlate");
		String startDateTime = request.getParameter("startDateTime");
		String endDateTime = request.getParameter("endDateTime");
		String reservationStatus = request.getParameter("reservationStatus");
		reservation.setNumberPlate(numberPlate);
		reservation.setStartDateTime(startDateTime);
		reservation.setEndDateTime(endDateTime);
		reservation.setReservationStatus(reservationStatus);

		String action = request.getParameter("action");

		if ("userManagement".equals(action)) {
			try {
				handleUserManagement(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("parkingSpotManagement".equals(action)) {
			try {
				handleParkingSpotManagement(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("reservationManagement".equals(action)) {
			try {
				handleReservationManagement(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("transactionManagement".equals(action)) {
			try {
				handleTransactionManagement(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Error");
		}

	}

	public void handleUserManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<RegistrationLogin> list = null;
		try {
			list = registrationLoginImpl.read();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ParkingSpot.jsp");
		dispatcher.forward(request, response);
	}

	public void handleReservationManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<Reservations> list = null;
		try {
			list = reservationDAO.readReservations();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ReservationApproval.jsp");
		dispatcher.forward(request, response);
	}

	public void handleParkingSpotManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<ParkingSpots> list = null;
		try {
			list = parkingSpotsDAO.readParkingSpots();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ParkingSpotManagement.jsp");
		dispatcher.forward(request, response);
	}

	public void handleTransactionManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<Transactions> list = null;
		try {
			list = transactionDAO.readTransactions();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionManagement.jsp");
		dispatcher.forward(request, response);
	}

}
