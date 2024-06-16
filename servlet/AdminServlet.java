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
	static RegistrationLogin registrationLogin = new RegistrationLogin();
	static Reservations reservation = new Reservations();
	static ParkingSpots parkingSpots = new ParkingSpots();
	static Transactions transactions = new Transactions();
	static RegistrationLoginImpl registrationLoginImpl = new RegistrationLoginImpl();
	static ReservationDAO reservationDAO = new ReservationDAO();
	static ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();
	static TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.html");
			dispatcher.forward(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("parkingSpot.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("reservationApproval.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("parkingSpotManagement.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("transactionManagement.jsp");
		dispatcher.forward(request, response);
	}

}
