<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Parking Spots Management</title>
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
		<h1 style="color: black;">PARKING SPOTS DETAILS</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(253, 220, 54); height: 40px;">
			<th style="color: black;">User Id</th>
			<th style="color: black;">Spot Id</th>
			<th style="color: black;">Location Name</th>
			<th style="color: black;">Address</th>
			<th style="color: black;">Vehicle Type</th>
			<th style="color: black;">Spot Number</th>
			<th style="color: black;">Spot Status</th>
			<th style="color: black;">Manage</th>
		</tr>
		<%
		List<ParkingSpots> list = (ArrayList<ParkingSpots>) request.getAttribute("list");
		if (list != null) {
			for (ParkingSpots parkingSpots : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=parkingSpots.getUserId()%></td>
			<td><%=parkingSpots.getSpotId()%></td>
			<td><%=parkingSpots.getLocationName()%></td>
			<td><%=parkingSpots.getAddress()%></td>
			<td><%=parkingSpots.getVehicleType()%></td>
			<td><%=parkingSpots.getSpotNumber()%></td>
			<td><%=parkingSpots.getSpotStatus()%></td>
			<td><form action="AdminServlet" method="get">
					<input type="hidden" name="spotId"
						value="<%=parkingSpots.getSpotId()%>"> <select
						name="spotsUpdate">
						<option>Select</option>
						<option value="false">false</option>
						<option value="true">true</option>
					</select><input type="submit" name="spotsUpdate" value="update"
						style="margin: 0 15px; border-color: rgb(253, 220, 54); background-color: white">
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<div style="text-align: center;">
		<form action="admin.jsp">
			<button type="submit"
				style="border-color: rgb(253, 220, 54); background-color: rgb(253, 220, 54); width: 117px; height: 37px;"
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
