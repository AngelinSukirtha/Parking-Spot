package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.model.*;

/**
 * Servlet implementation class RegistrationLoginServlet
 */
@WebServlet("/RegistrationLoginServlet")
public class RegistrationLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistrationLogin registrationLogin = new RegistrationLogin();
	RegistrationLoginImpl registrationLoginImpl = new RegistrationLoginImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

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
		System.out.println(action);
		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "register":
				try {

					if (registrationLoginImpl.userRegistration(registrationLogin)) {
						HttpSession session = request.getSession();
						session.setAttribute("userName", userName);
						session.setAttribute("userPassword", userPassword);
						session.setAttribute("phoneNumber", phoneNumber);
						session.setAttribute("email", email);
						response.sendRedirect("UserLogin.html");

					} else {
						response.sendRedirect("UserRegister.html");
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;

			case "login":
				try {
					if (userName.equals("Angelin") && userPassword.equals("Angelin1")
							&& phoneNumber.equals("9344868945") && email.equals("angelin@gmail.com")) {
						HttpSession session = request.getSession();
						session.setAttribute("userName", userName);
						session.setAttribute("userPassword", userPassword);
						session.setAttribute("phoneNumber", phoneNumber);
						session.setAttribute("email", email);
						List<RegistrationLogin> list = registrationLoginImpl.read();
						request.setAttribute("list", list);
						RequestDispatcher dispatcher = request.getRequestDispatcher("ParkingSpot.jsp");
						dispatcher.forward(request, response);
					} else {
						String email1 = registrationLoginImpl.userLogin(registrationLogin);
						if (email.equals(email1)) {
							HttpSession session = request.getSession();
							session.setAttribute("userName", userName);
							session.setAttribute("userPassword", userPassword);
							session.setAttribute("phoneNumber", phoneNumber);
							session.setAttribute("email", email);
							request.getRequestDispatcher("Location.html").forward(request, response);
						} else {
							request.getRequestDispatcher("UserLogin.html").forward(request, response);
						}
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Invalid");
			}
		}

	}

}
