<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transactions</title>
<style>
body {
	margin: 0;
}

table {
	border-collapse: collapse;
	width: 70%;
	margin: 20px auto;
}

h2 {
	text-align: center;
}

th, td {
	border: 1px solid rgb(232, 231, 231);
	text-align: center;
	padding: 8px;
}

th {
	background-color: rgb(217, 214, 214);
}

.view-button {
	background-color: rgb(218, 189, 43);
	color: black;
	border: none;
	border-radius: 4px;
	padding: 6px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
}

.view-button:hover {
	background-color: rgb(196, 169, 34);
}

select {
	width: 100%;
	padding: 6px 10px;
	border: none;
	border-radius: 4px;
	background-color: white;
}

input[type="datetime-local"] {
	width: calc(100% - 20px);
	padding: 6px 10px;
	border: none;
	border-radius: 4px;
	background-color: white;
}

nav {
	background-color: black;
	opacity: 0.9;
	overflow: hidden;
}

nav img {
	width: 80px;
	height: auto;
}

nav h1 {
	color: white;
	display: inline;
}

nav a {
	float: right;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topleft {
	float: left;
	margin: auto;
	display: inline;
	height: auto;
}
.btn1 {
	display: block;
	width: 80px;
	margin: 5px 5px;
	padding: 10px 20px;
	text-align: center;
	background-color: rgb(253, 220, 54);
	color: black;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.btn1:hover {
	background-color: rgba(253, 220, 54, 0.854);
	color: black;
}
</style>
</head>
<body>
	<nav>
		<img src="Photo/logo1.png" alt="Logo" class="topleft">
		<h1 class="topleft"
			style="color: rgb(253, 220, 54); margin-top: 10px;">Parking</h1>
		<h1 class="topleft" style="margin-top: 10px;">Spot</h1>
		<a href="index.html" target="blank" class="btn1">Logout</a>
	</nav>
	<h2>Transactions</h2>
	<form action="TransactionServlet" method="post">
		<table>
			<tr>
				<!-- <th>User ID</th> -->
				<th>Price</th>
				<th>Payment Method</th>
				<th>Transaction Time</th>
				<th>Payment Checkout</th>
			</tr>
			<%
			RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
			Transactions transaction = new Transactions();
			%>
			<tr>
				<%-- <td><%=registrationLogin.getUserId()%></td> --%>
				<td><%=request.getAttribute("price")%></td>
				<td><select name="paymentMethod">
						<option value="Credit Card">Credit Card</option>
						<option value="Debit Card">Debit Card</option>
				</select></td>
				<td><%=request.getAttribute("transactionTime")%></td>
				<td><button class="view-button">Pay</button></td>
			</tr>
			<%

			%>
		</table>
	</form>
</body>
</html>