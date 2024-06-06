package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String locationName = request.getParameter("locationName");
//		parkingSpots.setLocationName(locationName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String locationName = request.getParameter("action");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();

		if (locationName != null) {
			parkingSpots.setLocationName(locationName);
			System.out.println(locationName);

			try {
				switch (locationName) {
				case "Chennai":
					parkingSpotsDAO.addLocationName(parkingSpots);
					session.setAttribute("locationName", locationName);
					request.getRequestDispatcher("AddressChennai.html").forward(request, response);
					break;
				case "Madurai":
					parkingSpotsDAO.addLocationName(parkingSpots);
					session.setAttribute("locationName", locationName);
					request.getRequestDispatcher("AddressMadurai.html").forward(request, response);
					break;
				case "Bangalore":
					parkingSpotsDAO.addLocationName(parkingSpots);
					session.setAttribute("locationName", locationName);
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
				case "Peraiyur":
				case "Jayanagar":
				case "Whitefield":
				case "Domlur":
					parkingSpotsDAO.addAddress(parkingSpots);
					session.setAttribute("address", address);
					request.getRequestDispatcher("Spots.html").forward(request, response);
					break;
				default:
					System.out.println("Invalid address");
					break;
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
