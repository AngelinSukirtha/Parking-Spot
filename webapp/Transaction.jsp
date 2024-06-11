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
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	padding: 6px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
}

.view-button:hover {
	background-color: #45a049;
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
</style>
</head>
<body>
	<h2>Transactions</h2>
	<form action="TransactionServlet" method="post">
		<table>
			<tr>
				<th>User ID</th>
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
				<td><%=registrationLogin.getUserId()%></td>
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