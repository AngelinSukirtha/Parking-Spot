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
import com.chainsys.model.*;

/**
 * Servlet implementation class ParkingSpotsServlet
 */
@WebServlet("/ParkingSpotsServlet")
public class ParkingSpotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParkingSpots parkingSpots = new ParkingSpots();
	ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();

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

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();
		System.out.println(id);

		if (locationName != null) {
			parkingSpots.setLocationName(locationName);
			System.out.println(locationName);

			try {
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
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		if (address != null) {
			parkingSpots.setAddress(address);
			System.out.println(address);

			try {
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
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		String[] selectedSpots = request.getParameterValues("selectedSpots");

		if (selectedSpots != null && selectedSpots.length > 0) {
			for (String spotNumber : selectedSpots) {
				try {
					parkingSpotsDAO.addSpotNumber(id, spotNumber);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect("ReservationServlet");
		} else {
			response.sendRedirect("Location.html");
		}
	}
}
