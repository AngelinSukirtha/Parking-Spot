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
	background-color: rgb(253, 220, 54);
	border: none;
	color: black;
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
	background-color: rgb(196, 169, 34);
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
