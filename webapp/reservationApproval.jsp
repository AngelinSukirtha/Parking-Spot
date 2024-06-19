<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Reservation Approval</title>
<style>
body {
	margin: 0;
}

.center {
	text-align: center;
	margin: auto;
	font-size: 15px;
}

table {
	margin-top: 20px;
	margin-left: 100px;
	border-collapse: collapse;
	width: 80%;
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

footer {
	margin-top: 402px;
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
	<div class="center">
		<h1 style="color: black;">RESERVATION DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Reservation Id</th>
			<th style="color: black;">Number Plate</th>
			<th style="color: black;">Start Date And Time</th>
			<th style="color: black;">End Date And Time</th>
			<th style="color: black;">Reservation Status</th>
			<th style="color: black;">Approval</th>
		</tr>
		<%
		List<Reservations> list = (ArrayList<Reservations>) request.getAttribute("list");
		if (list != null) {
			for (Reservations reservation : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=reservation.getUserId()%></td>
			<td><%=reservation.getReservationId()%></td>
			<td><%=reservation.getNumberPlate()%></td>
			<td><%=reservation.getStartDateTime()%></td>
			<td><%=reservation.getEndDateTime()%></td>
			<td><%=reservation.getReservationStatus()%></td>
			<td><form action="AdminServlet" method="post">
					<input type="hidden" name="reservationId"
						value="<%=reservation.getReservationId()%>"> <select
						name="approval">
						<option>Select</option>
						<option>Approved</option>
						<option>Rejected</option>
					</select><input type="submit" name="approval" value="update"
						style="margin: 0 15px; border-color: rgb(253, 220, 54); background-color: white">
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<div style="margin-left: 100px;">
		<form action="admin.jsp">
			<button type="submit"
				style="border-color: rgb(253, 220, 54); background-color: rgb(253, 220, 54)"
				title="logout">Back</button>
		</form>
	</div>
	<footer
		style="background-color: black; opacity: 0.9; padding: 20px 0; color: white; display: flex; flex-direction: column; align-items: center;">
		<div style="text-align: center; margin-top: 20px;">
			<p>&copy; 2024 Parking Spot. All Rights Reserved.</p>
		</div>
	</footer>
</body>
</html>
