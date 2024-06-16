package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.*;
import com.chainsys.model.*;

/**
 * Servlet implementation class RegistrationLoginServlet
 */
@WebServlet("/RegistrationLoginServlet")
public class RegistrationLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RegistrationLogin registrationLogin = new RegistrationLogin();
	static RegistrationLoginImpl registrationLoginImpl = new RegistrationLoginImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationLoginServlet() {
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

		String action = request.getParameter("action");
		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "register":
				try {

					if (registrationLoginImpl.userRegistration(registrationLogin)) {
						response.sendRedirect("userLogin.html");
					} else {
						response.sendRedirect("userRegister.html");
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;

			case "login":
				try {
					if (email.equals("angelin@parkingspot.com") && userPassword.equals("Angelin1")) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
						dispatcher.forward(request, response);

					} else {
						String email1 = registrationLoginImpl.userLogin(registrationLogin);
						if (email.equals(email1)) {
							RegistrationLogin userId = registrationLoginImpl.getUserById(registrationLogin);

							HttpSession session = request.getSession();
							session.setAttribute("userId", userId);

							request.getRequestDispatcher("location.html").forward(request, response);
						} else {
							request.getRequestDispatcher("userLogin.html").forward(request, response);
						}
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;

			default:
				request.getRequestDispatcher("index.html").forward(request, response);
			}
		}

	}

}
