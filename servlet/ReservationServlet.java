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
	Transactions transaction = new Transactions();
	ReservationDAO reservationDAO = new ReservationDAO();
	TransactionDAO transactionDAO = new TransactionDAO();

	public ReservationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Reservation.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String numberPlate = request.getParameter("numberPlate");
		reservation.setNumberPlate(numberPlate);
		String startDateTime = request.getParameter("startDateTime");
		reservation.setStartDateTime(startDateTime);
		String endDateTime = request.getParameter("endDateTime");
		reservation.setEndDateTime(endDateTime);
		System.out.println(startDateTime);
		System.out.println(endDateTime);

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();
		System.out.println(id);

		try {
			reservationDAO.insertReservation(reservation, id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			transactionDAO.insertTransaction(reservation, transaction, id);
			transactionDAO.readTransactions(transaction, id);
			int price = transaction.getPrice();
			String transactionTime = transaction.getTransactionTime();
			System.out.println(price);
			System.out.println(transactionTime);
			transaction.setPrice(price);
			transaction.setTransactionTime(transactionTime);
			request.setAttribute("price", price);
			request.setAttribute("transactionTime", transactionTime);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Transaction.jsp").forward(request, response);
	}

}
