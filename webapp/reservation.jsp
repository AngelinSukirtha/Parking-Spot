<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.*"%>
<%@ page import="com.chainsys.dao.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reservation Page</title>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: black;
	color: white;
}

header {
	background-color: #333;
	color: white;
	padding: 20px 0;
	text-align: center;
}

.container {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #222;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1, h2 {
	text-align: center;
	color: white;
}

form {
	margin-top: 20px;
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 10px;
	font-weight: bold;
	color: white;
}

input[type="text"], input[type="datetime-local"] {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #444;
	border-radius: 5px;
	box-sizing: border-box;
	background-color: #333;
	color: white;
}

input[type="submit"] {
	margin-left: 150px;
	width: 50%;
	padding: 10px;
	background-color: rgb(218, 189, 43);
	color: black;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
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

footer {
	margin-top: 120px;
}
</style>
</head>
<body>
	<nav>
		<img src="Photo/logo1.png" alt="Logo" class="topleft">
		<h1 class="topleft"
			style="color: rgb(253, 220, 54); margin-top: 10px;">Parking</h1>
		<h1 class="topleft" style="margin-top: 10px;">Spot</h1>
		<a href="index.html" target="_blank" class="btn1">Logout</a>
	</nav>
	<div class="container">
		<h2>Reservation</h2>
		<%
		RegistrationLogin registrationLogin = (RegistrationLogin) session.getAttribute("userId");
		if (registrationLogin != null) {
			Integer id = registrationLogin.getUserId();
			ParkingSpotsDAO parkingSpotsDAO = new ParkingSpotsDAO();
			ParkingSpots parkingSpots = new ParkingSpots();
			parkingSpotsDAO.countSpotNumber(parkingSpots, id);
			int countSpotNumber = parkingSpots.getCountSpotNumber();
			out.println("Vehicle Count:" + countSpotNumber);
		} 
		%>
		<form action="ParkingSpotsServlet" method="post">
			<label for="numberPlate">Number Plate:</label> <input type="text"
				id="numberPlate" name="numberPlate" required> <label
				for="startDateTime">Start DateTime:</label> <input
				type="datetime-local" id="startDateTime" name="startDateTime"
				min="2024-06-13" required> <label for="endDateTime">End
				DateTime:</label> <input type="datetime-local" id="endDateTime"
				name="endDateTime" required> <input type="submit"
				value="Submit Reservation">
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