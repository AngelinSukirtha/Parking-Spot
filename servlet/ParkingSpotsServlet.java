package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.*;
import com.chainsys.model.*;

/**
 * Servlet implementation class ParkingSpotsServlet
 */
@WebServlet("/ParkingSpotsServlet")
public class ParkingSpotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ParkingSpots parkingSpots = new ParkingSpots();
	static ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();
	static Reservations reservation = new Reservations();
	static Transactions transaction = new Transactions();
	static ReservationDAO reservationDAO = new ReservationDAO();
	static TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingSpotsServlet() {
		super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String locationName = request.getParameter("action");
		String address = request.getParameter("address");
		String[] selectedSpots = request.getParameterValues("selectedSpots");

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();

		try {
			if (locationName != null) {
				handleLocation(request, response, id, locationName);
			} else if (address != null) {
				handleAddress(request, response, id, address);
			} else if (selectedSpots != null) {
				String vehicleType = request.getParameter("vehicleType");
				parkingSpots.setVehicleType(vehicleType);
				handleSelectedSpots(request, response, id, selectedSpots, vehicleType);
			} else {
				handleReservation(request, response, id, parkingSpots);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleLocation(HttpServletRequest request, HttpServletResponse response, int id, String locationName)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		parkingSpots.setLocationName(locationName);

		switch (locationName) {
		case "Chennai":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("addressChennai.html").forward(request, response);
			break;
		case "Madurai":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("addressMadurai.html").forward(request, response);
			break;
		case "Bangalore":
			parkingSpotsDAO.addLocationName(parkingSpots, id);
			request.getRequestDispatcher("addressBangalore.html").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
		}
	}

	public void handleAddress(HttpServletRequest request, HttpServletResponse response, int id, String address)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		parkingSpots.setAddress(address);

		if (address.equals("Mylapore") || address.equals("Velachery") || address.equals("Perungudi")
				|| address.equals("Alanganallur") || address.equals("Kalavasal") || address.equals("Periyar")
				|| address.equals("Jayanagar") || address.equals("Whitefield") || address.equals("Domlur")) {
			parkingSpotsDAO.addAddress(parkingSpots, id);
			request.getRequestDispatcher("spots.jsp").forward(request, response);
		} else {
			response.sendRedirect("location.html");
		}
	}

	public void handleSelectedSpots(HttpServletRequest request, HttpServletResponse response, int id,
			String[] selectedSpots, String vehicleType)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		parkingSpots.setVehicleType(vehicleType);

		for (String spotNumber : selectedSpots) {
			parkingSpotsDAO.addSpotNumber(id, vehicleType, spotNumber);
		}

		request.getRequestDispatcher("reservation.html").forward(request, response);
	}

	public void handleReservation(HttpServletRequest request, HttpServletResponse response, int id,
			ParkingSpots parkingSpots) throws ServletException, IOException, ClassNotFoundException, SQLException {

		String numberPlate = request.getParameter("numberPlate");
		reservation.setNumberPlate(numberPlate);
		String startDateTime = request.getParameter("startDateTime");
		reservation.setStartDateTime(startDateTime);
		String endDateTime = request.getParameter("endDateTime");
		reservation.setEndDateTime(endDateTime);

		reservationDAO.insertReservation(reservation, id);

		transactionDAO.insertTransaction(reservation, parkingSpots, id);
		transactionDAO.readTransactions(transaction, id);
		int price = transaction.getPrice();
		String transactionTime = transaction.getTransactionTime();

		request.setAttribute("price", price);
		request.setAttribute("transactionTime", transactionTime);
		request.getRequestDispatcher("transaction.jsp").forward(request, response);
	}

}
