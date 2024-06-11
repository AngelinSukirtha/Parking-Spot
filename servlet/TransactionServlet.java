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
 * Servlet implementation class TransactionServlet
 */
@WebServlet(urlPatterns = "/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transactions transaction = new Transactions();
	Reservations reservation = new Reservations();
	TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionServlet() {
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
		System.out.println("hii");

		String startDateTime = request.getParameter("startDateTime");
		reservation.setStartDateTime(startDateTime);
		String endDateTime = request.getParameter("endDateTime");
		reservation.setEndDateTime(endDateTime);

		int price = Integer.parseInt(request.getParameter("price"));
		transaction.setPrice(price);
		String paymentMethod = request.getParameter("paymentMethod");
		transaction.setPaymentMethod(paymentMethod);
		String transactionTime = request.getParameter("transactionTime");
		transaction.setTransactionTime(transactionTime);
		String paymentStatus = request.getParameter("paymentStatus");
		transaction.setPaymentStatus(paymentStatus);

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();
		System.out.println(id);

		try {
			transactionDAO.insertTransaction(reservation, transaction, id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Transaction.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
//		System.out.println("hii");
//
//		String startDateTime = request.getParameter("startDateTime");
//		reservation.setStartDateTime(startDateTime);
//		String endDateTime = request.getParameter("endDateTime");
//		reservation.setEndDateTime(endDateTime);
//
//		int price = Integer.parseInt(request.getParameter("price"));
//		transaction.setPrice(price);
//		String paymentMethod = request.getParameter("paymentMethod");
//		transaction.setPaymentMethod(paymentMethod);
//		String transactionTime = request.getParameter("transactionTime");
//		transaction.setTransactionTime(transactionTime);
//		String paymentStatus = request.getParameter("paymentStatus");
//		transaction.setPaymentStatus(paymentStatus);
//
//		HttpSession session = request.getSession(false);
//		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
//		int id = registrationLogin.getUserId();
//		System.out.println(id);
//
//		try {
//			transactionDAO.insertTransaction(reservation, id);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher("Transaction.jsp").forward(request, response);
	}

}
