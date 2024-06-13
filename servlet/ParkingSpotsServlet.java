package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.ParkingSpotsDAO;
import com.chainsys.dao.ReservationDAO;
import com.chainsys.dao.TransactionDAO;
import com.chainsys.model.*;

/**
 * Servlet implementation class ParkingSpotsServlet
 */
@WebServlet("/ParkingSpotsServlet")
public class ParkingSpotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParkingSpots parkingSpots = new ParkingSpots();
	ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();
	Reservations reservation = new Reservations();
	Transactions transaction = new Transactions();
	ReservationDAO reservationDAO = new ReservationDAO();
	TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingSpotsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      protected void doGet(HttpServletRequest request, HttpServletResponse
	 *      response) throws ServletException, IOException {
	 * 
	 *      } * response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String locationName = request.getParameter("action");
		String address = request.getParameter("address");
		String[] selectedSpots = request.getParameterValues("selectedSpots");
		String vehicleType = request.getParameter("vehicleType");

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();
		parkingSpots.setVehicleType(vehicleType);

		try {
			if (locationName != null) {
				handleLocation(request, response, id, locationName);
			} else if (address != null) {
				handleAddress(request, response, id, address);
			} else if (selectedSpots != null) {
				handleSelectedSpots(request, response, id, selectedSpots, vehicleType);
			} else {
				handleReservation(request, response, id, vehicleType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleLocation(HttpServletRequest request, HttpServletResponse response, int id, String locationName)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		parkingSpots.setLocationName(locationName);
		System.out.println(locationName);

		switch (locationName) {
		case "Chennai":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("AddressChennai.html").forward(request, response);
			break;
		case "Madurai":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("AddressMadurai.html").forward(request, response);
			break;
		case "Bangalore":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("AddressBangalore.html").forward(request, response);
			break;
		default:
			System.out.println("Invalid location");
			break;
		}
	}

	private void handleAddress(HttpServletRequest request, HttpServletResponse response, int id, String address)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		parkingSpots.setAddress(address);
		System.out.println(address);

		switch (address) {
		case "Mylapore":
		case "Velachery":
		case "Perungudi":
		case "Alanganallur":
		case "Kalavasal":
		case "Periyar":
		case "Jayanagar":
		case "Whitefield":
		case "Domlur":
			parkingSpotsDAO.addAddress(parkingSpots, id);
			request.getRequestDispatcher("Spots.jsp").forward(request, response);
			break;
		default:
			System.out.println("Invalid address");
			response.sendRedirect("Location.html");
			break;
		}
	}

	private void handleSelectedSpots(HttpServletRequest request, HttpServletResponse response, int userId,
			String[] selectedSpots, String vehicleType)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		ParkingSpots parkingSpots = new ParkingSpots();
		parkingSpots.setVehicleType(vehicleType);
		System.out.println(vehicleType);

		for (String spotNumber : selectedSpots) {
			parkingSpotsDAO.addSpotNumber(userId, vehicleType, spotNumber);
		}

		request.getRequestDispatcher("Reservation.html").forward(request, response);
	}

	private void handleReservation(HttpServletRequest request, HttpServletResponse response, int id, String vehicleType)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String numberPlate = request.getParameter("numberPlate");
		reservation.setNumberPlate(numberPlate);
		String startDateTime = request.getParameter("startDateTime");
		reservation.setStartDateTime(startDateTime);
		String endDateTime = request.getParameter("endDateTime");
		reservation.setEndDateTime(endDateTime);
		System.out.println(startDateTime);
		System.out.println(endDateTime);

		parkingSpots.setVehicleType(vehicleType);
		System.out.println(vehicleType);

		reservationDAO.insertReservation(reservation, id);

		transactionDAO.insertTransaction(reservation, vehicleType, id);
		int price = transaction.getPrice();
		String transactionTime = transaction.getTransactionTime();
		System.out.println(price);
		System.out.println(transactionTime);

		request.setAttribute("price", price);
		request.setAttribute("transactionTime", transactionTime);
		request.getRequestDispatcher("Transaction.jsp").forward(request, response);
	}

}
