package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.TransactionDAO;
import com.chainsys.model.RegistrationLogin;
import com.chainsys.model.Transactions;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Transactions transaction = new Transactions();
	static TransactionDAO transactionDAO = new TransactionDAO();
	static RegistrationLogin registrationLogin = new RegistrationLogin();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionServlet() {
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
		String paymentMethod = request.getParameter("paymentMethod");
		transaction.setPaymentMethod(paymentMethod);

		HttpSession session = request.getSession(false);
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		int id = registrationLogin.getUserId();

		try {
			transactionDAO.addPaymentMethod(id, paymentMethod);
			transactionDAO.readTransactions(transaction, id);
			String userName = registrationLogin.getUserName();
			String phoneNumber = registrationLogin.getPhoneNumber();
			String email = registrationLogin.getEmail();
			int price = transaction.getPrice();
			String transactionTime = transaction.getTransactionTime();

			registrationLogin.setUserName(userName);
			registrationLogin.setPhoneNumber(phoneNumber);
			registrationLogin.setEmail(email);
			transaction.setPrice(price);
			transaction.setTransactionTime(transactionTime);

			request.setAttribute("userName", userName);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("price", price);
			request.setAttribute("transactionTime", transactionTime);

			request.getRequestDispatcher("transactionConfirmation.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("transaction.jsp");
		}

	}

}
