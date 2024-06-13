<%@ page import="com.chainsys.model.*"%>
<%@ page import="com.chainsys.dao.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Parking Spot Admin Dashboard</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.container {
	padding: 20px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}

.card {
	width: calc(50% - 20px);
	padding: 20px;
	border: 1px solid rgb(232, 232, 232);
	border-radius: 5px;
	margin-bottom: 20px;
	box-sizing: border-box;
}

.card-header {
	font-size: 24px;
	margin-bottom: 10px;
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin-top: 10px;
	cursor: pointer;
	border-radius: 5px;
}

.button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<div class="card">
			<form action="AdminServlet" method="post">
				<input type="hidden" name="action" value="userManagement">
				<div class="card-header">User Management</div>
				<a href="ParkingSpot.jsp"><button class="button">Manage</button></a>
			</form>
		</div>

		<div class="card">
			<form action="AdminServlet" method="post">
				<input type="hidden" name="action" value="parkingSpotManagement">
				<div class="card-header">Parking Spot Management</div>
				<a href="ParkingSpotManagement.jsp"><button class="button">Manage</button></a>
			</form>
		</div>

		<div class="card">
			<form action="AdminServlet" method="post">
				<input type="hidden" name="action" value="reservationManagement">
				<div class="card-header">Reservation Management</div>
				<a href="ReservationApproval.jsp"><button class="button">Approve
						Reservation</button></a>
			</form>
		</div>

		<div class="card">
			<form action="AdminServlet" method="post">
				<input type="hidden" name="action" value="transactionManagement">
				<div class="card-header">Transaction Management</div>
				<a href="TransactionManagement.jsp"><button class="button">Refund
						Transaction</button></a>
			</form>
		</div>
	</div>
</body>
</html>
